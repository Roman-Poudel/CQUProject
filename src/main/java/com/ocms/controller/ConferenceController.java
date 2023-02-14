package com.ocms.controller;

import com.ocms.entity.Conference;
import com.ocms.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    //Listing Conference
    @GetMapping("/showconference")
    public String listConference(Model model){
       List <Conference> listConference = conferenceService.listConference();
        model.addAttribute("listConference",listConference);
       if(listConference.isEmpty()){
           return ("/nodatafound");
       }
       else
           return ("/showconference");
    }

    // Registering Conference
    @GetMapping("/registerconference")
    //rendering the Conference form
    public String registerConference(Model model){
        Conference conference=new Conference();
        model.addAttribute("conference", conference);

        return "/registerconference";
    }

    //Register the Conference
    @PostMapping("/registerconference")
    public String saveConference(@ModelAttribute("conference") Conference conference){
        conferenceService.createConference(conference);
        return "redirect:/showconference";
    } // Register Conference Finishes

    //Edit of conference Starts here
    //fetching the UI
    @GetMapping("/editconference/{confID}")
    public ModelAndView updateConference(@PathVariable("confID") String confID){
        ModelAndView mv= new ModelAndView("editconference");
        Conference conference = conferenceService.viewDetailById(confID);
        mv.addObject("conference", conference);

        return mv;
    }
    // Saving the edit here
    @PostMapping("/editconference")
    public String updateOrganization(@ModelAttribute("publisher")Conference conference){
        conferenceService.createConference(conference);

        return "redirect:/showconference";
    }// Conference Updated

    // deleting the Conference BY ID
    @GetMapping("deleteconference/{confID}")
    public String deleteConferece(@PathVariable("confID") String confID ){
        conferenceService.deleteConference(confID);
        return ("redirect:/showconference");

    }
    //Searching Conference
    // Searching by keyword
    @RequestMapping("/searchconference")
    public String searchConference(Model model, @Param("keyword") String keyword) {
        String searchKeyword =keyword.trim().toLowerCase();
        System.out.println(searchKeyword.trim());
        List<Conference> searchConferences = conferenceService.searchConference(searchKeyword);
        model.addAttribute("searchConferences", searchConferences);
        System.out.println(searchConferences);
//        if(searchConference.isEmpty()){
//            return "/nodatafound";
//        }
//        else
            return "/searchconference";
    }

}
