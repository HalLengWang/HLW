package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "login_after";
    }

    @GetMapping("/test/1")
    public String login() {
        return "Login-before";
    }

    @GetMapping("/test/2")
    public String login2() {
        return "Login-after";
    }

    @GetMapping("/test/3")
    public String list() {
        return "ToDo-List";
    }
}