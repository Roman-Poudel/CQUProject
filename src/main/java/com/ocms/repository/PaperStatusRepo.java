package com.ocms.repository;

import com.ocms.entity.PaperStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PaperStatusRepo extends JpaRepository<PaperStatus, String> {
}
