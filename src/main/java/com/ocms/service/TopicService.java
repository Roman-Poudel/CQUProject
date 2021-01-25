package com.ocms.service;

import com.ocms.entity.Topic;
import com.ocms.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> listTopic(){
        return topicRepo.findAll();
    }

    public void registerTopic(Topic topic){
        topicRepo.save(topic);
    }

    public void deleteTopic(String topicID){topicRepo.deleteById(topicID);}

    public Topic viewDetailsById(String topicID){
        return topicRepo.findById(topicID).get();

    }
}
