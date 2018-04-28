package com.haiwen.adserver.utils;
import com.haiwen.adserver.domain.Ad;
import org.springframework.data.redis.cache.RedisCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AdsSelector {
    private static AdsSelector instance = null;
    private RedisCache cache;
    protected AdsSelector(RedisCache cache) {
        this.cache = cache;
    }

    public static AdsSelector getInstance(RedisCache cache) {
        if(instance == null) {
            instance = new AdsSelector(cache);
        }
        return instance;
    }

    public List<Ad> selectAds(List<String> queryTemrs) {
        List<Ad> adList = new ArrayList<Ad>();
        HashMap<Long, Integer> matchedAds = new HashMap<Long, Integer>();

        for (String query : queryTemrs) {
            Set<Long> adIdList = (Set<Long>) cache.get(query);
            if(adIdList != null && adIdList.size() > 0) {
                for (Object adId : adIdList) {
                    Long key = (Long) adId;
                    if(matchedAds.containsKey(key)) {
                        int count = matchedAds.get(key) + 1;
                        matchedAds.put(key, count);
                    } else {
                        matchedAds.put(key, 1);
                    }
                }
            }
        }

        for(Long adId : matchedAds.keySet()) {

        }

        return adList;
    }

}
