package com.example.MMP.wod;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WodService {
    public void create(String image, String content) {
        Wod wod = new Wod();
        wod.setImage(image);
        wod.setContent(content);
        wod.setCreateDate(LocalDateTime.now());
    }
}
