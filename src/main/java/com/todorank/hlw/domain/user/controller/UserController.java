package com.todorank.hlw.domain.user.controller;

import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.entity.UserContext;
import com.todorank.hlw.domain.user.form.UserCreateForm;
import com.todorank.hlw.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String userSignup(UserCreateForm userCreateForm) {
        return "signup_page";
    }

    @PostMapping("/signup")
    public String userSignup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_page";
        }
        if (!userCreateForm.getPassword().equals(userCreateForm.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "password incorrect", "비밀번호가 다릅니다.");
            return "signup_page";
        }
        try {
            this.userService.create(userCreateForm.getUsername(), userCreateForm.getPassword(),
                    userCreateForm.getEmail(), userCreateForm.getNickname());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signup_page error", "이미 가입된 아이디 혹은 이메일입니다.");
            return "signup_page";
        }
        return "login_after";
    }

    @GetMapping("/login")
    public String userLogin() {
        return "login_page";
    }

    // 프로필 수정 -> 닉네임, 자기소개 데이터 가져와 화면에 출력
    @GetMapping("/profile_modify")
    public String profileModify(Principal principal, Model model) {
        SiteUser siteUser = userService.getUser(principal.getName());
        if (siteUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "사용자를 찾을 수 없습니다.");
        }
        model.addAttribute("user", siteUser);
        return "profile_modify_page";
    }

    // 프로필 수정 -> 변경사항 저장 버튼 클릭시 닉네임, 자기소개 값 수정
    @PostMapping("/profile_modify")
    public String profileModify(
            @RequestParam("nickname") String nickname,
            @RequestParam("intro") String intro,
            Principal principal,
            @RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
            Model model
    ) {
        SiteUser siteUser = userService.getUser(principal.getName());
        if (siteUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "사용자를 찾을 수 없습니다.");
        }

        siteUser.setNickname(nickname);
        siteUser.setIntro(intro);

        if (thumbnail != null && !thumbnail.isEmpty()) {
            userService.saveUser(siteUser, thumbnail);
        } else {
            userService.saveUser(siteUser);
        }

        // 수정된 사용자 정보를 모델에 추가하여 다시 렌더링할 때 반영
        model.addAttribute("user", siteUser);
        /*return "redirect:/user/profile_modify";*/
        return "login_after";
    }


}
