
package com.exam.java_exam.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.java_exam.model.Task;
import com.exam.java_exam.model.User;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

    List<Task> findAll();
    List<Task> findByPubUserAndStatus(User user, String status);
    List<Task> findByPubUserAndIsImportant(User user, boolean important);
    List<Task> findByPubUser(User user);
    
}
