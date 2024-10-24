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

    // login_after로 getmapping시
    private final UserService userService;

    @GetMapping("/")
    public String userLoginAfter(
            Principal principal,
            @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
            Model model)
    {
        if (principal == null) {
            return "login_after";
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
            return "login_after";
        }

        SiteUser siteUser = userService.getUser(principal.getName());
        model.addAttribute("user", siteUser);
        return "profile_read_page";
    }



}
