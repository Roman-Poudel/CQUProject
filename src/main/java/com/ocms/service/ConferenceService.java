package com.ocms.service;

import com.ocms.entity.Conference;
import com.ocms.repository.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {


    @Autowired
    private ConferenceRepo conferenceRepo;

    public void createConference(Conference conference){
        conferenceRepo.save(conference);
    }

    public List<Conference> listConference(){
        return conferenceRepo.findAll();

    }

    public void deleteConference(String confID){conferenceRepo.deleteById(confID);}

    public Conference viewDetailById(String confID){
        return conferenceRepo.findById(confID).get();
    }

    // Searching the Conference
    public List<Conference> searchConference(String keyword) {
        if (keyword != null) {
            return conferenceRepo.search(keyword);
        }
        else
           return conferenceRepo.findAll();
    }

    public List<Conference> upcomingConference(){
        return conferenceRepo.upcomingConference();

    }




}
