package com.haiwen.adserver.rest;

import com.haiwen.adserver.domain.Ad;
import com.haiwen.adserver.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchAdsController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Ad> searchAds(
            @RequestParam(name = "q", required = false, defaultValue = "") String query
    ) {

        List<Ad> adsCandidates = adService.selectAds(query);
        return adsCandidates;
    }

    @RequestMapping(value = "/ads", method = RequestMethod.GET)
    public ResponseEntity<List<Ad>> getAllAds() {
        List<Ad> ads = adService.findAll();
        return new ResponseEntity<List<Ad>>(ads, HttpStatus.OK);
    }

    @RequestMapping(value = "/ads/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdById(@PathVariable Long id) {
        Ad ad = adService.findById(id);
        return new ResponseEntity<Ad>(ad, HttpStatus.OK);
    }
}
