package com.ocms.controller;

import com.ocms.entity.User;
import com.ocms.service.OrganizationService;
import com.ocms.service.PaperService;
import com.ocms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PaperService paperService;

    @GetMapping("/register")
    //rendering the regiter form
    public String registerUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    //Register the user
    @PostMapping("/register")
    public String saveUsers(@ModelAttribute("user") User user) {
        userService.saveUsers(user);

        return "redirect:/showusers";
    }

    //Retrieving the user list
    @GetMapping("/showusers")
    public String listUsers(Model model) {
        List<User> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);
        return "showusers";
    }


    //update user by uid
    //fetching the UI
    @GetMapping("/edituser/{uID}")
    public ModelAndView updateUser(@PathVariable("uID") String uID, Model model) {
        ModelAndView mv = new ModelAndView("edituser");
        User user = userService.viewDetailsByID(uID);
        mv.addObject("user", user);
//        List<Organization> listOrganization = organizationService.listOrganization();
//        model.addAttribute("listOrganization",listOrganization);
        return mv;
    }

    //Making Change on the basis of UID
    @PostMapping("/edituser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUsers(user);
        return "redirect:/showusers";
    }

    // edit finish
    //delete user by uid
    @GetMapping("/deleteuser/{uID}")
    public String deleteUser(@PathVariable("uID") String uID) {
        userService.deleteUsers(uID);
        return "redirect:/showusers";
    }

    // Searching by keyword
    @RequestMapping("/searchuser")
    public String searchuser(Model model, @Param("keyword") String keyword) {
        String searchKeyword = keyword.trim().toLowerCase();
        System.out.println(searchKeyword);
        List<User> searchuser = userService.searchUser(searchKeyword.trim());
        model.addAttribute("searchuser", searchuser);
        System.out.println(searchuser);
        if (searchuser.isEmpty())
            return "/nodatafound";
        else
            return "/searchuser";

    }

    //Retrieving the user Details
    @GetMapping("/userdetail/{uID}")
    public ModelAndView userDetail(@PathVariable("uID") String uID) {
        ModelAndView mv = new ModelAndView("userdetail");
        User user = userService.viewDetailsByID(uID);
        mv.addObject("user", user);

        return mv;
    }

    @GetMapping("/userprofile/{uID}")
    public ModelAndView userProfile(@PathVariable("uID") String uID) {
        ModelAndView mv = new ModelAndView("userprofile");
        User user = userService.viewDetailsByID(uID);
        mv.addObject("user", user);
        return mv;
    }

}
