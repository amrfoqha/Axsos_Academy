package com.example.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.loginandregistration.models.User;
import com.example.loginandregistration.models.UserLogin;
import com.example.loginandregistration.repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User createUser(User user,BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(user.getEmail());
        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "this email already exist.");
        }
        if (!user.getPassword().equals(user.getConfirm())) {
            result.rejectValue("confirm", "Matches", "passwords doesn't matches.");
        }
        if(result.hasErrors()){
            return null;
        }
     
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPassword);


    return userRepo.save(user);
}
    public User loginUser(UserLogin user,BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(user.getLoginEmail());
        if (!potentialUser.isPresent()) {
            result.rejectValue("loginEmail", "NotFound", "this email doesn't exist.");
            return null;
        }
        User goldUser = potentialUser.get();
        if (!BCrypt.checkpw(user.getLoginPassword(), goldUser.getPassword())) {
            result.rejectValue("loginPassword", "Matches", "passwords or email wrong.");
            return null;
        }
        if (result.hasErrors()) {
            return null;
        }
        
    return goldUser;
}
public User findUserById(Long id) {
    return userRepo.findById(id).orElse(null);
}
}
