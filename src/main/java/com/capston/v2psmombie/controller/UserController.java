package com.capston.v2psmombie.controller;


import com.capston.v2psmombie.dto.UserCreateDto;
import com.capston.v2psmombie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    /**
     * 사용자 등록
     **/
    @PostMapping("/users")
    public ResponseEntity<String> create(@RequestBody UserCreateDto dto) {
        try {
            String createdUserDeviceId = userService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("[SUCCSS] 사용자 생성: " + createdUserDeviceId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("[FAIL] 사용자 생성: " + e.getMessage());
        }
    }

}
