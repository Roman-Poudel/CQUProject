package com.ocms.repository;

import com.ocms.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface PaperRepo extends JpaRepository<Paper, String> {

    @Query("SELECT p FROM Paper p WHERE  CONCAT(lower( p.paperID), lower(p.paperTopic), lower( p.paperTitle), " +
            "lower( p.paperPublisher), p.paperID,p.paperTopic, p.paperTitle, " +
        "p.paperPublisher) LIKE %?1%")
    List<Paper> search(String keyword);

    @Query("SELECT p FROM Paper p WHERE LOWER(p.user) LIKE id" )
    Paper viewUserDetailByID(String id);

    @Query("SELECT p FROM Paper p where p.paperStatus = 'RECEIVED' ")
    List<Paper> findPaperByGroup();

    @Query("SELECT p FROM Paper p where p.paperTopic = 'TOPIC1' ")
    List<Paper> findPaperByTOPIC1();




    @Modifying
    @Query( "update Paper p set p.paperStatus = 'DENIED' where p.paperID in :id")
    void updateStatus(List<String> id);



}

