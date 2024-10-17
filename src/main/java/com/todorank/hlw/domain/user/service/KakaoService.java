package com.todorank.hlw.domain.user.service;

import com.todorank.hlw.domain.user.entity.KakaoUser;
import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.repository.KakaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KakaoService {
    private final KakaoRepository kakaoRepository;
    private final PasswordEncoder passwordEncoder;

    public KakaoUser create(String username, String password, String email, String nickname) {
        KakaoUser kakaoUser = KakaoUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .nickname(nickname)
                .intro(String.format("반갑습니다! %s입니다~", nickname))
                .build();
        return this.kakaoRepository.save(kakaoUser);
    }

    @Transactional
    public KakaoUser whenSocialLogin(String providerTypeCode, String username, String nickname) {
        Optional<KakaoUser> opUser = findByUsername(username);

        if (opUser.isPresent()) {
            // 이미 존재하는 사용자일 경우, 해당 사용자 정보를 반환
            return opUser.get();
        }

        // 소셜 로그인 시 비밀번호는 필요 없으므로 빈 문자열을 전달
        // 처음 로그인 시 사용자 생성
        KakaoUser kakaoUser = create(username, "", "", nickname); // create 메서드 호출
        return kakaoUser; // 새로 생성된 사용자 반환
    }
    private Optional<KakaoUser> findByUsername(String username) {
        return kakaoRepository.findByUsername(username);
    }
}