package com.todorank.hlw.domain.home;

import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class MainController {

    /*@GetMapping("/")
    public String root() {
        return "login_after";
    }*/

    // login_after로 getmapping시
    private final UserService userService;

    @GetMapping("/")
    public String userLoginAfter(
            Principal principal,
            @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
            Model model)
    {
        if (principal == null) {
            return "redirect:/login_before";
        }

        SiteUser siteUser = userService.getUser(principal.getName());
        model.addAttribute("user", siteUser);
        return "login_after";
    }

    @GetMapping("/profile_read")
    public String userProfileRead(
            Principal principal,
            @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
            Model model)
    {
        if (principal == null) {
            return "redirect:/login_before";
        }

        SiteUser siteUser = userService.getUser(principal.getName());
        model.addAttribute("user", siteUser);
        return "profile_read_page";
    }

    /*@GetMapping("/profile_read")
    public String root1() {
        return "profile_read_page";
    }*/

    /*@GetMapping("/profile_modify")
    public String root2() {
        return "profile_modify_page";
    }*/

    @GetMapping("/todo_list_detail")
    public String root5() {
        return "todo_list_detail";
    }

    @GetMapping("/rankings_list")
    public String root6() {
        return "rankings_list_page";
    }

    @GetMapping("/remembrance")
    public String root7() {
        return "remembrance_page";
    }

    @GetMapping("/signup")
    public String root8() {
        return "signup_page";
    }

    @GetMapping("/todo_card_read_create")
    public String root9() {
        return "todo_card_read_create_page";
    }

    @GetMapping("/retrospective_from")
    public String root10() {
        return "retrospective_from_page";
    }

    @GetMapping("/login_before")
    public String root11() {
        return "login_before";
    }

    @GetMapping("/todo_list")
    public String root12() {
        return "todo_list";
    }

    @GetMapping("/profile_modify")
    public String root13() {
        return "profile_modify_page";
    }

    @GetMapping("/navbar")
    public String root14() {
        return "navbar";
    }

}
