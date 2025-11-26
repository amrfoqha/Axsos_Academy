package com.exam.java_exam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.java_exam.model.Task;
import com.exam.java_exam.model.User;
import com.exam.java_exam.repository.TaskRepo;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private userService userService;

    public Task createTask(Task task, User user) {
        task.setPubUser(user);
        return taskRepo.save(task);
    }

    public List<Task> getUserTasks(User user) {
        return taskRepo.findByPubUser(user);
    }
    public List<Task> getInprogressTasks(User user) {
        return taskRepo.findByPubUserAndStatus(user, "inProgress");
    }
    public List<Task> getDoneTasks(User user) {
        return taskRepo.findByPubUserAndStatus(user, "Done");
    }

    public List<Task> getImportantTasks(User user) {
        return taskRepo.findByPubUserAndIsImportant(user, true);
    }

    public void toggleImportance(Long id, User user) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null && task.getPubUser().getId() == user.getId()) {
            task.setIsImportant(!task.getIsImportant());
            taskRepo.save(task);
        }
    }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public void toggleInProgress(Long id, User user) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null && task.getPubUser().getId() == user.getId()) {
            task.setStatus("inProgress");
            taskRepo.save(task);
        }
    }

    public void toggleDone(Long id, User user) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null && task.getPubUser().getId() == user.getId()) {
            task.setStatus("Done");
            taskRepo.save(task);
        }
    }

    public void updateTask(Task task, Long id, User user) {
        Task oldTask = taskRepo.findById(id).orElse(null);
        if (oldTask != null && oldTask.getPubUser().getId() == user.getId()) {
            oldTask.setName(task.getName());
            oldTask.setDueDate(task.getDueDate());
            oldTask.setDescription(task.getDescription());
            oldTask.setIsImportant(task.getIsImportant());
            taskRepo.save(oldTask);
        }
    }
    public void deleteTask(Long id, User user) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null && task.getPubUser().getId() == user.getId()) {
            taskRepo.delete(task);
        }
    }
    
    public void updateOverdueTasks(User user) {
        Date date = new Date();
        List<Task> tasks = taskRepo.findByPubUser(user);
        for (Task task : tasks) {
            if (task.getDueDate().before(date) ) {
                task.setStatus("Done");
                taskRepo.save(task);
            }
        }
    }
}
