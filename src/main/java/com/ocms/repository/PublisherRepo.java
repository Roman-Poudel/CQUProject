package com.ocms.repository;

import com.ocms.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, String>,
        PagingAndSortingRepository<Publisher, String> {
    //
}
