package com.haiwen.adserver.repository;

import com.haiwen.adserver.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
