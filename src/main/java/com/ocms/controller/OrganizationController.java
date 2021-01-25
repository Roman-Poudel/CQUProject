package com.ocms.controller;

import com.ocms.entity.Organization;
import com.ocms.service.OrganizationService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // Registering Organization
    @GetMapping("/registerorganization")
    //rendering the regiter form
    public String registerOrganization(Model model){
        Organization organization = new Organization();
        model.addAttribute("organization", organization);
        return "registerorganization";
    }

    //Register the organization
    @PostMapping("/registerorganization")
    public String saveOrganization(@ModelAttribute("organization") Organization organization){
        organizationService.saveOrganization(organization);

        return "redirect:/showorganization";
    } // Register Organization Finishes

    //Listing all the organization
    @GetMapping("/showorganization")
    public String listOrganization(Model model){
        List<Organization> listOrganization = organizationService.listOrganization();
        model.addAttribute("listOrganization",listOrganization);
        return "showorganization";
    }

    //Edit of Organizaiton Starts here
    //fetching the UI
    @GetMapping("/editorganization/{orgID}")
    public ModelAndView updateOrganization(@PathVariable(name = "orgID") String orgID){
        ModelAndView mv= new ModelAndView("editorganization");
        Organization organization = organizationService.viewDetailByID(orgID);
        mv.addObject("organization", organization);

        return mv;
    }
    // Saving the edit here
    @PostMapping("/editorganization")
    public String updateOrganization(@ModelAttribute("organization")Organization organization){
        organizationService.saveOrganization(organization);
        return "redirect:/showorganization";
    }// orgnization Updated


    //delete organization by {orgID}
    @GetMapping("/deleteorganization/{orgID}")
    public String deleteOrganization(@PathVariable("orgID") String orgID){
        organizationService.deleteOrganization(orgID);

        return "redirect:/showorganization";
    }   //deletion of Organizatin Finished here


}
