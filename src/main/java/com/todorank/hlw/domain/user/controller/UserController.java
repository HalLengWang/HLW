package com.todorank.hlw.domain.user.controller;

import com.todorank.hlw.domain.user.form.UserCreateForm;
import com.todorank.hlw.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

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
    public String userSignup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessages", bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList()));
            return "redirect:/user/signup";
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
}
