package com.haiwen.adserver.service;

import com.haiwen.adserver.domain.Ad;

import java.util.List;
import java.util.Optional;

public interface AdService {
    public List<Ad> selectAds(String query);

    public List<Ad> findAll();

    public Ad findById(Long id);

}
