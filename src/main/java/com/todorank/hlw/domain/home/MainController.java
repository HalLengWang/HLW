package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "홈입니다.";
    }
    @GetMapping("/todo/detail")
    public String detail(){
        return "todo_list_detail";
    }
}