package com.todorank.hlw.domain.remembrance.repository;

import com.todorank.hlw.domain.remembrance.entity.Remembrance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemembranceRepository extends JpaRepository<Remembrance, Long> {
}
