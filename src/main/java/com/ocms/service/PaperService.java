package com.ocms.service;

import com.ocms.entity.Paper;
import com.ocms.repository.PaperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperRepo paperRepo;

    // returning List of Paper entiy
    public List<Paper> listPapers() {
        return paperRepo.findAll();
    }

    // saving the paper entity
    public void savePaper(Paper paper) {

        paperRepo.save(paper);
    }

    // deleting the paper by id
    public void deletePaper(String id) {
        paperRepo.deleteById(id);
    }

//Searching the Paper
    public List<Paper> searchPaper(String keyword) {
        if (keyword != null) {
            return paperRepo.search(keyword);
        }
        return paperRepo.findAll();
    }

    //retrieving particular Paper info
    public Paper viewDetailByID(String id){
        return paperRepo.findById(id).get();
    }

    public Paper viewUserDetailByID(String id){
        return paperRepo.viewUserDetailByID(id);
    }

    public void updateStatus(List<String> id){

         paperRepo.updateStatus(id);

    }

    // returning List of paper entiy
    public List<Paper> listPaperByGroup() {
        return paperRepo.findPaperByGroup();
    }

    public List<Paper> listPaperByTopic() {
        return paperRepo.findPaperByTOPIC1();
    }

    public List<Paper> findAll(){
        return findAll();
    }


}
