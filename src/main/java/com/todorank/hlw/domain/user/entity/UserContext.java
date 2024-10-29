package com.todorank.hlw.domain.user.entity;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class UserContext extends User {
    private final Long id;
    private final String nickname;
    private final String thumbnailImg;

    @Value("${default.thumbnail}")  // 기본 프로필 이미지 경로
    private String defaultThumbnail;

    public UserContext(SiteUser siteUser, List<GrantedAuthority> authorities) {
        super(siteUser.getUsername(), siteUser.getPassword(), authorities);
        this.id = siteUser.getId();
        this.nickname = siteUser.getNickname();
        this.thumbnailImg = siteUser.getThumbnailImg();
    }

    public String getThumbnailImg() {
        // NullPointerException을 피하기 위해 안전하게 처리
        return (thumbnailImg != null) ? thumbnailImg : "/profile_basic.png";
    }
}
