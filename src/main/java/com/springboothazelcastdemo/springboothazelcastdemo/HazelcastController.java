package com.springboothazelcastdemo.springboothazelcastdemo;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hazelcast")
public class HazelcastController {

    @Autowired
    private HazelcastInstance hazelcastInstance;


    @PostMapping(value = "/write-data")
    public String writeDataToHazelcast(@RequestParam String key, @RequestParam String value) {
        hazelcastInstance
                .getMap("my-map")
                .put(key, value);
        return "Data is stored.";
    }

    @GetMapping(value = "/read-data")
    public String readDataFromHazelcast(@RequestParam String key) {
        return (String) hazelcastInstance
                            .getMap("my-map")
                            .get(key);
    }

    @GetMapping(value = "/read-all-data")
    public Map<String, String> readAllDataFromHazelcast() {
        return hazelcastInstance.getMap("my-map");
    }

}

