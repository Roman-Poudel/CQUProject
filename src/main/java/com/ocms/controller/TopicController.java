package com.ocms.controller;

import com.ocms.entity.Topic;
import com.ocms.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/showtopic")
    public String listTopics(Model model){
        List<Topic> listTopics=topicService.listTopic();
        model.addAttribute("listTopics",listTopics);
        return ("/showtopic");
    }

    // Registering topic
    //show the register form
    @GetMapping("/registertopic")
    public String registerTopic(Model model){
        Topic topic=new Topic();
        model.addAttribute("topic",topic);
        return ("/registertopic");
    }

    @PostMapping("/registertopic")
    public String saveTopic(@ModelAttribute ("topic") Topic topic){
        topicService.registerTopic(topic);
        return("redirect:/showtopic");

    }
    // Edit of TOPIC by topicID
    @GetMapping("/edittopic/{topicID}")
    public ModelAndView updateTopic(@PathVariable(name = "topicID") String topicID){
        ModelAndView mv= new ModelAndView("editTopic");
        Topic topic = topicService.viewDetailsById(topicID);
        mv.addObject("topic", topic);

        return mv;
    }
    // Saving the edit here
    @PostMapping("/edittopic")
    public String updateOrganization(@ModelAttribute("topic")Topic topic){
        topicService.registerTopic(topic);

        return "redirect:/showtopic";
    }
    // Deleting by TopicID
    @GetMapping("/deletetopic/{topicID}")
    public String deletePaper(@PathVariable("topicID") String topicID){
        topicService.deleteTopic(topicID);

        return "redirect:/showtopic";
    }


}
