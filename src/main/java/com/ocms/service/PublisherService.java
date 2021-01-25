package com.ocms.service;

import com.ocms.entity.Publisher;
import com.ocms.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    public void savePublisher(Publisher publisher){publisherRepo.save(publisher);
    }

    public List<Publisher> listPublisher(){
        return publisherRepo.findAll();

    }

    public void deletePublisher(String topicID){publisherRepo.deleteById(topicID);}

    public Publisher viewDetailsById(String pubID){
        return publisherRepo.findById(pubID).get();

    }

//    public List<Publisher> findByPublisherName(){
//        return publisherRepo.findAllByPublisherName();
//    }

}
