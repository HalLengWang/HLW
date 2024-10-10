package com.todorank.hlw.domain.user.service;

import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String username, String password, String email, String nickname) {
        SiteUser user = SiteUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .nickname(nickname)
                .intro(String.format("반갑습니다! %s입니다~", nickname))
                .build();
        this.userRepository.save(user);
    }
}
