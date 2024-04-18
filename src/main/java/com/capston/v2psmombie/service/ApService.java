package com.capston.v2psmombie.service;

import com.capston.v2psmombie.domain.Ap;
import com.capston.v2psmombie.dto.ApCreateDto;
import com.capston.v2psmombie.repository.ApRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ApService {

    private final ApRepository apRepository;


    @Transactional
    public Ap create(ApCreateDto dto) {
        if (apRepository.findByName(dto.getName()).isPresent()) {
            throw new IllegalArgumentException("이미 해당 이름의 AP가 존재합니다");
        }

        Ap newAp = Ap.builder(dto.getName())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();

        Ap created = apRepository.save(newAp);
        return created;
    }

}

