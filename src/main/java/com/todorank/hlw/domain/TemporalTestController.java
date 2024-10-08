package com.todorank.hlw.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemporalTestController {
    @GetMapping("/signup")
    public String index(){
        return "signup";
    }

    @GetMapping("/login")
    public String index2(){
        return "login";
    }

    @GetMapping("/todolist_inquiry")
    public String index3(){
        return "todolist_inquiry";
    }

    @GetMapping("/todocard_read_create")
    public String index4(){
        return "todocard_read_create";
    }
}
