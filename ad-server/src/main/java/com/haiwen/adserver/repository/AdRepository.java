package com.haiwen.adserver.repository;

import com.haiwen.adserver.domain.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long>{
}
