package com.haiwen.adserver.service.impl;

import com.haiwen.adserver.domain.Campaign;
import com.haiwen.adserver.repository.CampaignRepository;
import com.haiwen.adserver.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CampaignServiceImpl implements CampaignService{
    private CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign findById(Long id) {
        Optional<Campaign> campaignOptional = campaignRepository.findById(id);
        return campaignOptional.get();
    }
}
