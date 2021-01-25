package com.ocms.service;

import com.ocms.entity.PaperStatus;
import com.ocms.repository.PaperStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperStatusService {
    @Autowired
    private PaperStatusRepo paperStatusRepo;

    // returning List of PaperStatus entiy
    public List<PaperStatus> listPaperStatus() {

        return paperStatusRepo.findAll();
    }
}
