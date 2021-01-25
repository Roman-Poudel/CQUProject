package com.ocms.controller;

import com.ocms.entity.Publisher;
import com.ocms.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    // Listing Publishers
    @GetMapping("/showpublisher")
    public String listPublisher(Model model){
        List<Publisher> listPublisher = publisherService.listPublisher();
        model.addAttribute("listPublisher",listPublisher);
        return ("/showpublisher");
    }

    // Registering Publisher
    //show the register form
    @GetMapping("/registerpublisher")
    public String registerPublisher(Model model){
        Publisher publisher=new Publisher();
        model.addAttribute("publisher",publisher);
        return ("/registerpublisher");
    }

    @PostMapping("/registerpublisher")
    public String savePublisher(@ModelAttribute ("publisher") Publisher publisher){
        publisherService.savePublisher(publisher);
        return("redirect:/showpublisher");

    }// New Publisher Registered

    //Edit of Organizaiton Starts here
    //fetching the UI
    @GetMapping("/editpublisher/{pubID}")
    public ModelAndView updatePublisher(@PathVariable(name = "pubID") String pubID){
        ModelAndView mv= new ModelAndView("editpublisher");
        Publisher publisher = publisherService.viewDetailsById(pubID);
        mv.addObject("publisher", publisher);

        return mv;
    }
    // Saving the edit here
    @PostMapping("/editpublisher")
    public String updatePublisher(@ModelAttribute("publisher")Publisher publisher){
        publisherService.savePublisher(publisher);
        return "redirect:/showpublisher";
    }// orgnization Updated

    //delete organization by {orgID}
    @GetMapping("/deletepublisher/{pubID}")
    public String deletePublisher(@PathVariable("pubID") String pubID){
        publisherService.deletePublisher(pubID);
        return "redirect:/showpublisher";
    }   //deletion of Organizatin Finished here

}
