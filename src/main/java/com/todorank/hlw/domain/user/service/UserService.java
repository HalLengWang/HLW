package com.todorank.hlw.domain.user.service;

import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String password, String email, String nickname) {
        SiteUser user = SiteUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .nickname(nickname)
                .intro(String.format("반갑습니다! %s입니다~", nickname))
                .build();
        return this.userRepository.save(user);
    }

    public SiteUser getUser(String username) {
        return this.userRepository.findByusername(username).orElse(null);
    }

    public SiteUser getUser(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

//    @Transactional
//    public SiteUser whenSocialLogin(String providerTypeCode, String username, String nickname) {
//        Optional<SiteUser> opUser = findByUsername(username);
//
//        if (opUser.isPresent()) {
//            // 이미 존재하는 사용자일 경우, 해당 사용자 정보를 반환
//            return opUser.get();
//        }
//
//        // 소셜 로그인 시 비밀번호는 필요 없으므로 빈 문자열을 전달
//        // 처음 로그인 시 사용자 생성
//        SiteUser siteUser = create(username, "", "", nickname); // create 메서드 호출
//        return siteUser; // 새로 생성된 사용자 반환
//    }


    private Optional<SiteUser> findByUsername(String username) {
        return userRepository.findByusername(username);
    }
}
