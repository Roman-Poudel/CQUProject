package com.ocms.service;

import com.ocms.entity.Organization;
import com.ocms.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepo organizationRepo;

    public void saveOrganization(Organization organization){
        organizationRepo.save(organization);
    }

    public List<Organization> listOrganization(){
        return organizationRepo.findAll();

    }

    public void deleteOrganization(String orgID){ organizationRepo.deleteById(orgID);}

    public Organization viewDetailByID(String id){
        return organizationRepo.findById(id).get();
    }
}
