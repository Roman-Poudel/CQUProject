package com.ocms.controller;

import com.ocms.entity.Conference;
import com.ocms.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ConferenceService conferenceService;

    @GetMapping("/")
    public String upcomingConference(Model model) {
        List<Conference> upcomingConference = conferenceService.upcomingConference();
        System.out.println(upcomingConference);
        model.addAttribute("upcomingConference", upcomingConference);
        return "home";
    }

    @GetMapping("/aboutus")
    public String aboutUs() {
        return "aboutus";
    }

    @GetMapping("/contactus")
    public String conatctUs() {
        return "contactus";
    }


}
