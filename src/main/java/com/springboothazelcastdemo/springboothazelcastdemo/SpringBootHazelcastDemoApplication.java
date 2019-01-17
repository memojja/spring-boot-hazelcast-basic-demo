package com.springboothazelcastdemo.springboothazelcastdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;

@SpringBootApplication
public class SpringBootHazelcastDemoApplication implements CommandLineRunner {

    @Autowired
    private MusicService musicService;

    //@Autowired
    //private CacheManager cacheManager;

    Logger logger = LoggerFactory.getLogger(SpringBootHazelcastDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHazelcastDemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        musicService.clearCache();

        logger.info("Using cache manager " ); // + cacheManager.getClass().getName());

        play("trombone");
        play("guitar");
        play("trombone");
        play("bass");
        play("trombone");
        play("trombone");
    }

    private void play(String instrument) {
        logger.info("calling : " + MusicService.class.getName() );
        musicService.play(instrument);
    }
}

