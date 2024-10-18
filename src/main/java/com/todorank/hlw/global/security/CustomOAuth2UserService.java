package com.todorank.hlw.global.security;


import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.service.KakaoService;
import com.todorank.hlw.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final KakaoService kakaoService;

    // 카카오톡 로그인이 성공할 때마다 이 함수가 실행된다.
    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String oauthId = oAuth2User.getName();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 카카오 계정의 nickname과 추가 속성 가져오기
        Map<String, Object> attributesProperties = (Map<String, Object>) attributes.get("properties");
        String nickname = (String) attributesProperties.get("nickname");

        // 프로바이더 코드 설정 (KAKAO로 변환)
        String providerTypeCode = userRequest.getClientRegistration().getRegistrationId().toUpperCase();

        // 사용자 이름 형식 지정
        String username = providerTypeCode + "__%s".formatted(oauthId);

        // 카카오 사용자를 생성하거나 검색
        SiteUser siteUser = kakaoService.whenSocialLogin(providerTypeCode, username, nickname); // 카카오 서비스에서 SiteUser를 반환받음

        List<GrantedAuthority> authorityList = new ArrayList<>();

        // CustomOAuth2User를 반환
        return new CustomOAuth2User(siteUser.getUsername(), siteUser.getPassword(), authorityList); // SiteUser의 정보를 사용
    }
}
