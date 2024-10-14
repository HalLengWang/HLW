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
        return "login_after";
    }
    @GetMapping("/d")
    public String detail() {
        return "todo_list_detail";
    }
    @GetMapping("/c")
    public String todolist() {
        return "remembrance";
    }
}