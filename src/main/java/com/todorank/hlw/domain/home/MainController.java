package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "login_after";
    }
    @GetMapping("/todo")
    public String todo(){
        return "todo_list";
    }
}