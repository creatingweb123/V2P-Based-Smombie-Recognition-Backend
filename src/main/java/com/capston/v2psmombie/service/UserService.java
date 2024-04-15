package com.capston.v2psmombie.service;

import com.capston.v2psmombie.domain.User;
import com.capston.v2psmombie.dto.UserCreateDto;
import com.capston.v2psmombie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public String create(UserCreateDto dto) {

        User user = dto.toUserEntity();
        if (userRepository.findByDeviceId(user.getDeviceId()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 디바이스입니다");
        }
        return userRepository.save(user).getDeviceId();
    }


}

