package com.ocms.repository;

import com.ocms.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository <User, String>{


    @Query("SELECT u FROM User u WHERE  trim( concat(lower( u.uID), lower(u.uName), lower( u.email), u.uID, u.uName, u.email)) LIKE %?1%" )
     List<User> search(String keyword);

}
