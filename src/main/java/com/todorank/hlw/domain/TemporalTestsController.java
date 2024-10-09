package com.todorank.hlw.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemporalTestsController {
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/todocard_read_create")
    public String todocard_read_create() {
        return "todocard_read_create";
    }
}
