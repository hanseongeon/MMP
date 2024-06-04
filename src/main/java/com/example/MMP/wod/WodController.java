package com.example.MMP.wod;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/wod")
public class WodController {
    private WodService wodService;

    @GetMapping("/form")
    private String wod(){
        return "wod_form";
    }
}
