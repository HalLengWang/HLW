package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/todo_card_read_create_page")
    public String root(){
        return "/todo_card_read_create_page";
    }

}
