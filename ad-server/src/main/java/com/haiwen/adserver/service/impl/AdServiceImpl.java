package com.haiwen.adserver.service.impl;

import com.haiwen.adserver.domain.Ad;
import com.haiwen.adserver.repository.AdRepository;
import com.haiwen.adserver.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdServiceImpl implements AdService{

    private AdRepository adRepository;

    @Autowired
    public AdServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public List<Ad> selectAds(String query) {
        List<Ad> queryTerms = adRepository.findAll();
        return queryTerms;
    }

    @Override
    public List<Ad> findAll() {
        return adRepository.findAll();
    }

    @Override
    public Ad findById(Long id) {
        Optional<Ad> adOptional = adRepository.findById(id);
        return adOptional.get();
    }

}
