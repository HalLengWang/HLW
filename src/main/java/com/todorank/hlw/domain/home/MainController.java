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
    public String test1() {
        return "login";
    }

    @GetMapping("/test/2")
    public String test2() {
        return "login_after";
    }

    @GetMapping("/test/3")
    public String test3() {
        return "login_before";
    }

    @GetMapping("/test/4")
    public String test4() {
        return "profile_modify";
    }

    @GetMapping("/test/5")
    public String test5() {
        return "profile_read";
    }

    @GetMapping("/test/6")
    public String test6() {
        return "signup";
    }

    @GetMapping("/test/7")
    public String test7() {
        return "todo_list";
    }

    @GetMapping("/test/8")
    public String test8() {
        return "todo_list_detail";
    }

    @GetMapping("/test/9")
    public String test9() {
        return "todo_card_read_create";
    }

    @GetMapping("/test/10")
    public String test10() {
        return "rankings_list_page";
    }

    @GetMapping("/test/11")
    public String test11() {
        return "remembrance";
    }
}
