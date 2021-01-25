package com.ocms.repository;

import com.ocms.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepo extends JpaRepository<Conference, String> {

    @Query("select c from Conference c where  " +
            "( concat(lower( c.conferenceID), lower(c.conferenceName), lower( c.conferenceTheme),lower( c.conferenceDescription), " +
            "c.conferenceID, c.conferenceName, c.conferenceTheme, c.conferenceDescription)) LIKE %?1%")
    List<Conference> search(String keyword);


    @Query(value = "SELECT * FROM tbl_conference order by tbl_Conference.conferenceID desc limit 5", nativeQuery = true)
    List<Conference> upcomingConference();


}
