package com.ocms.repository;

import com.ocms.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository <Group, String>{
    /*@Query("SELECT p FROM Paper p WHERE  CONCAT(lower( p.paperID), lower(p.paperTopic), lower( p.paperTitle), " +
            "lower( p.paperPublisher), p.paperID,p.paperTopic, p.paperTitle, " +
            "p.paperPublisher) LIKE %?1%")*/
//    List<Group> search(String keyword);
}
