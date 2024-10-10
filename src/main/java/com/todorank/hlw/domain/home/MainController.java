package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/user/signup";
    }

    @GetMapping("/login")
    public String root1() {
        return "login";
    }

    @GetMapping("/todo_card_read_create")
    public String root2() {
        return "todo_card_read_create";
    }

    @GetMapping("/signup")
    public String root3() {
        return "signup";
    }

    @GetMapping("/profile_read")
    public String root4() {
        return "profile_read";
    }

    @GetMapping("/profile_modify")
    public String root5() {
        return "profile_modify";
    }

    @GetMapping("/remembrance")
    public String root6() {
        return "remembrance";
    }
}