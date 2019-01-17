package com.springboothazelcastdemo.springboothazelcastdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "instruments")
public class MusicService {

    private Logger logger  = LoggerFactory.getLogger(MusicService.class);

    @CacheEvict(allEntries = true)
    public void clearCache(){}

    @Cacheable(condition = "#instrument.equals('trombone')")
    public String play(String instrument){
        logger.info("Executing :  " + getClass().getSimpleName()  + "play ( " + instrument + " )");
        return "Playing : " + instrument;
    }

}
