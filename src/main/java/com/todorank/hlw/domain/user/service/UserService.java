package com.todorank.hlw.domain.user.service;

import com.todorank.hlw.domain.user.entity.SiteUser;
import com.todorank.hlw.domain.user.form.UserCreateForm;
import com.todorank.hlw.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 프로필 정보 두줄 추가
    @Value("${default.thumbnail}")  // 기본 프로필 이미지 경로를 설정 (application.yml 또는 application.properties에 설정)
    private String defaultThumbnail;

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

    public SiteUser getUser(String username) {
        return this.userRepository.findByusername(username).orElse(null);
    }
    public SiteUser getUser(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    // 프로필
    public SiteUser getUserByNickname(String nickname) {
        return this.userRepository.findByNickname(nickname).orElse(null);
    }

    // 프로필 이미지
    @Value("${custom.fileDirPath}")
    private String fileDirPath;

    public void saveUser(SiteUser user, MultipartFile thumbnail) {
        if (!thumbnail.isEmpty()) {
            String thumbnailRelPath = "SiteUser/" + UUID.randomUUID().toString() + ".jpg";
            File thumbnailFile = new File(fileDirPath + "/" + thumbnailRelPath);

            try {
                thumbnail.transferTo(thumbnailFile);
                user.setThumbnailImg(thumbnailRelPath);  // 사용자 엔티티에 이미지 경로 저장
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        userRepository.save(user);
    }

    // 프로필 업데이트
    public void saveUser(SiteUser user) {
        if (user.getThumbnailImg() == null || user.getThumbnailImg().isEmpty()) {
            user.setThumbnailImg(defaultThumbnail);  // 기본 프로필 이미지를 설정
        }
        userRepository.save(user);
    }

    // 프로필 -> 회원가입 시 thumbnail 기본값
    /*@Value("${default.thumbnail}")
    private String defaultThumbnail;

    public SiteUser registerUser(UserCreateForm form) {
        SiteUser siteUser= new SiteUser();
        siteUser.setUsername(form.getUsername());
        siteUser.setPassword(passwordEncoder.encode(form.getPassword()));

        // thumbnail 값이 없으면 설정 파일에서 기본 값 가져오기
        if (form.getThumbnail() == null || form.getThumbnail().isEmpty()) {
            siteUser.setThumbnailImg(defaultThumbnail);
        } else {
            siteUser.setThumbnailImg(form.getThumbnail());
        }

        return userRepository.save(siteUser);
    }*/



}
