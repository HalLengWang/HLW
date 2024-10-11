package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "login_after";
    }

    @GetMapping("/navbar")
    public String root1() {
        return "navbar";
    }

    @GetMapping("/login")
    public String root2() {
        return "login";
    }

    @GetMapping("/profile_read")
    public String root3() {
        return "profile_read";
    }

    @GetMapping("/todo_card_read_create")
    public String root4() {
        return "todo_card_read_create";
    }
}
