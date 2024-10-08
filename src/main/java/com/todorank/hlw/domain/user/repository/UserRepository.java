package com.todorank.hlw.domain.user.repository;

import com.todorank.hlw.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}
