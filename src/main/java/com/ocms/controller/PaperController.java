package com.ocms.controller;

import com.ocms.entity.Paper;
import com.ocms.entity.PaperStatus;
import com.ocms.entity.Publisher;
import com.ocms.entity.Topic;
import com.ocms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class PaperController {

    @Autowired
    private UserService userService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PaperStatusService paperStatusService;

    //rendering the regiter Paper form
    @GetMapping("/registerpaper")
    public String showPaperForm(Model model){
//        final String UPLOAD_DIR = "./uploads/";
        Paper paper = new Paper();
        model.addAttribute("paper", paper);
        List<Topic> listTopic = topicService.listTopic();
        model.addAttribute("listTopic", listTopic);
        List<Publisher> listPublisher = publisherService.listPublisher();
        model.addAttribute("listPublisher", listPublisher);
//        ZonedDateTime timezone= ZonedDateTime.now();
//        model.addAttribute("timezone",timezone);
        ZonedDateTime timezone= ZonedDateTime.now();
        TimeZone tz= TimeZone.getTimeZone(timezone.getZone());
        String countryZone=tz.getID();
        System.out.println(countryZone);



        String[] locales = Locale.getISOCountries();
        List<String> countries=new ArrayList<String>();
        for (String countryCode : locales) {
            Locale obj = new Locale("en", countryCode);
            countries.addAll(Collections.singleton(obj.getDisplayCountry()));
            model.addAttribute("countries",countries);
        }

        return "registerpaper";
    }

    //Register the Paper
    @PostMapping("/registerpaper")
    public String savePaper(@ModelAttribute("paper") Paper paper) {
        paperService.savePaper(paper);

        return "redirect:/showpapers";
    }

    //Listing All the Papers
    @GetMapping("/showpapers")
    public String listPapers(Model model) {
        List<Paper> listPapers = paperService.listPapers();
        model.addAttribute("listPapers", listPapers);

        return "showpapers";
    }

    //delete Paper by {paperID}
    @GetMapping("/deletepaper/{paperID}")
    public String deletePaper(@PathVariable("paperID") String paperID) {
        paperService.deletePaper(paperID);

        return "redirect:/showpapers";
    }

    //update Paper by PaperID
    //fetching the UI
    @GetMapping("/editpaper/{paperID}")
    public ModelAndView updatePaper(@PathVariable(name = "paperID") String paperID, Model model) {
        ModelAndView mv = new ModelAndView("editpaper");
        Paper paper = paperService.viewDetailByID(paperID);
        mv.addObject("paper", paper);
        List<Topic> listTopic = topicService.listTopic();
        model.addAttribute("listTopic", listTopic);
        List<Publisher> listPublisher = publisherService.listPublisher();
        model.addAttribute("listPublisher", listPublisher);
        List<PaperStatus> listStatus = paperStatusService.listPaperStatus();
        model.addAttribute("listStatus", listStatus);

        return mv;
    }

    //Making Change on the basis of
    // PaperID
    @PostMapping("/editpaper")
    public String updatePaper(@ModelAttribute("paper") Paper paper) {
        paperService.savePaper(paper);
        return "redirect:/showpapers";
    } // Edit finish

    // Searching by keyword
    @RequestMapping("/searchpaper")
    public String searchPaper(Model model, @Param("keyword") String keyword) {
        String searchKeyword = keyword.trim().toLowerCase();
        List<Paper> searchpaper = paperService.searchPaper(searchKeyword);
        model.addAttribute("searchpaper", searchpaper);

        return "searchpaper";
    }

    //Retrieving the Paper Details
    @GetMapping("/paperdetail/{papeID}")
    public ModelAndView paperDetail(@PathVariable("papeID") String paperID) {
        ModelAndView mv = new ModelAndView("paperdetail");
        Paper paper = paperService.viewDetailByID(paperID);
        mv.addObject("paper", paper);

        return mv;
    }

    @GetMapping("/showpapersbygroup")
    public String listPapersByGroup(Model model) {
        List<Paper> listByGroups = paperService.listPaperByGroup();
        List<Paper> group1ForConference = new ArrayList<>();
        group1ForConference.addAll(listByGroups); // can also use for copying the object and/or list retrieved
        /* Working on Grouping*/

        int groupSize = 3;
        AtomicInteger counter = new AtomicInteger();
        Collection<List<Paper>> resultForGroup = group1ForConference.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / groupSize)).values();
        // finishing the grouping
        model.addAttribute("resultForGroup",resultForGroup);

        return "/showpapersbygroup";
    }
}
