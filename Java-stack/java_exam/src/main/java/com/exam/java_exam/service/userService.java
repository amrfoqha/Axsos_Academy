package com.exam.java_exam.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.exam.java_exam.model.LoginUser;
import com.exam.java_exam.model.Task;
import com.exam.java_exam.model.User;
import com.exam.java_exam.repository.UserRepo;

@Service
public class userService {

    @Autowired
    private UserRepo userRepo;

    public void save(User user){
        userRepo.save(user);
    }
    public User createUser(User user,BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(user.getEmail());
        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "this email already exist.");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Matches", "passwords doesn't matches.");
            
        }
        if(result.hasErrors()){
            return null;
        }
     
        String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPassword);


    return userRepo.save(user);
}
    public User loginUser(LoginUser user,BindingResult result) {
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
public User findUserByEmail(String email) {
    return userRepo.findByEmail(email).orElse(null);
}




}
