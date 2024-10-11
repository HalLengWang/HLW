package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "login_after";
    }
    @GetMapping("/t")
    public String t(){
        return "login_before";
    }
    @GetMapping("/todo")
    public String toto(){
        return "todo_list_detail";
    }
}