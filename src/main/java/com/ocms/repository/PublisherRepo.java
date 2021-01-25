package com.ocms.repository;

import com.ocms.entity.Publisher;
import javafx.scene.control.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, String>,
        PagingAndSortingRepository<Publisher, String> {
    //
}
