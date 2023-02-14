package com.ocms.controller;

import com.ocms.entity.Group;
import com.ocms.entity.Paper;
import com.ocms.entity.Topic;
import com.ocms.entity.User;
import com.ocms.service.GroupService;
import com.ocms.service.PaperService;
import com.ocms.service.TopicService;
import com.ocms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private TopicService topicService;



    @GetMapping("/showgroups")
     String listGroups(Model model) {
        List<Group > listGroups = groupService.listGroups();
        model.addAttribute("listGroups", listGroups);
        return "/showgroups";
    }
    //Creating a Group
    @GetMapping("/registergroup")
    public String showGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        List<User> listUser = userService.listUsersNotInGroup();
        model.addAttribute("listUser", listUser);

        List<Topic> listTopic = topicService.listTopic();
        model.addAttribute("listTopic", listTopic);
        List<Paper> listPaper = paperService.listPaperByTopic();

        model.addAttribute("listPaper", listPaper);


        return "/registergroup";
    }


    //Register the Group
    @PostMapping("/registergroup")
    public String saveGroup(@ModelAttribute("group") Group group, Model model) {
        groupService.createGroup(group);
        return "redirect:/registergroup";

    }


    //delete Group
    @GetMapping("/deletegroup/{groupID}")
    public String deleteGroup(@PathVariable("groupID") String groupID) {
        groupService.deleteGroup(groupID);

        return "redirect:/showgroup";
    }

}
