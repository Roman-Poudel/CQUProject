package com.ocms.service;

import com.ocms.entity.Group;
import com.ocms.entity.User;
import com.ocms.repository.GroupRepo;
import com.ocms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GroupRepo groupRepo;

    // returning List of User entiy
    public List<User> listUsers() {
        return userRepo.findAll();
    }
    //returning the user not in groups
    public List<User> listUsersNotInGroup() {

        List<Group> group = groupRepo.findAll();
        List<User> user = userRepo.findAll();
        List<User> filterdUser=user.stream().filter(e->!group.contains(e)).collect(Collectors.toList());
        return filterdUser;
    }

    // saving the user entity
    public void saveUsers(User user) {
        userRepo.save(user);
    }

    // deleting the user by user.UID
    public void deleteUsers(String id) {
         userRepo.deleteById(id);
    }

    //Update the user by User.UID
    public User updateUsers(String id){
        return userRepo.findById(id).get();

    }

    // Searching the user
    public List<User> searchUser(String keyword) {
        if (keyword != null) {
            return userRepo.search(keyword);
        }
        return userRepo.findAll();
    }

    //retrieving particular use info
    public User viewDetailsByID(String id){
        return userRepo.findById(id).get();
        //return userRepo.findById(id).get();
    }

}

