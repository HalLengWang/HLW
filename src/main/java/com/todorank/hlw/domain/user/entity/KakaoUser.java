package com.todorank.hlw.domain.user.entity;

import com.todorank.hlw.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUser extends BaseEntity {
    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @Column(unique = true)
    private String socialProvider;

    @Column(columnDefinition = "text")
    private String intro;

    private String nickname;
}
