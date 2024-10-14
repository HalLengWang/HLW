package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "login_after";
    }
    @GetMapping("/b")
    public String before() {
        return "todo_list";
    }
    @GetMapping("/c")
    public String rankings(){
        return "rankings_list_page";
    }
}