package com.todorank.hlw.domain.user.repository;

import com.todorank.hlw.domain.user.entity.KakaoUser;
import com.todorank.hlw.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface KakaoRepository extends JpaRepository<KakaoUser, Long> {
    Optional<KakaoUser> findByUsername(String username);
}
