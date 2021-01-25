package com.ocms.service;

import com.ocms.entity.Group;
import com.ocms.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;
// Listing all the group
    public List<Group> listGroups(){
       return groupRepo.findAll();
    }

    //Creating Group
    public void createGroup(Group group){
        groupRepo.save(group);
    }
    // deleting the paper by id
    public void deleteGroup(String id) {
        groupRepo.deleteById(id);
    }

    //Searching the Group
  /*  public List<Group> searchGroup(String keyword) {
        if (keyword != null) {
            return groupRepo.search(keyword);
        }
        return groupRepo.findAll();
    }*/
    //retrieving particular Paper info
    public Group viewDetailByID(String id){
        return groupRepo.findById(id).get();
    }

}
