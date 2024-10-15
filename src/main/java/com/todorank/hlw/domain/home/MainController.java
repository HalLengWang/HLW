package com.todorank.hlw.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "login_after";
    }

    @GetMapping("/login_before")
    public String root1() {
        return "login_before";
    }

    @GetMapping("/login")
    public String root2() {
        return "login_page";
    }

    @GetMapping("/navbar")
    public String root3() {
        return "navbar";
    }

    @GetMapping("/profile_modify")
    public String root4() {
        return "profile_modify_page";
    }

    @GetMapping("/profile_read")
    public String root5() {
        return "profile_read_page";
    }

    @GetMapping("/rankings_list")
    public String root6() {
        return "rankings_list_page";
    }

    @GetMapping("/remembrance")
    public String root7() {
        return "remembrance_page";
    }

    @GetMapping("/retrospective_from")
    public String root8() {
        return "retrospective_from_page";
    }

    //500에러
    @GetMapping("/signup")
    public String root9() {
        return "signup_page";
    }

    @GetMapping("/todo_card_read_create")
    public String root10() {
        return "todo_card_read_create_page";
    }

    // URL 경로로 직접 접근시 500 에러(루트경로에서 접근할 것)
    @GetMapping("/todo_list")
    public String root11() {
        return "todo_list";
    }

    //수정할 것(페이징)
    @GetMapping("/todo_list_detail")
    public String root12() {
        return "todo_list_detail";
    }

}