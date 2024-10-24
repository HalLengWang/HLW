package com.todorank.hlw.domain.rankings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class RankingsController {
    @GetMapping("/rankings/list")
    public String rankings(){
        return "rankings_list_page";
    }
}
