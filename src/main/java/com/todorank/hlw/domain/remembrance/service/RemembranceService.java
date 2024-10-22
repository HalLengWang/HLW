package com.todorank.hlw.domain.remembrance.service;

import com.todorank.hlw.domain.remembrance.repository.RemembranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemembranceService {
    private final RemembranceRepository remembranceRepository;
}
