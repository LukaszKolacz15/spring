package com.akademiakodu.spring.models;

import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Created by Lukasz Kolacz on 27.05.2017.
 */

@Service
public class SimpleBean {
    public String generateString(){
        return UUID.randomUUID().toString();
    }
}
