package com.capston.v2psmombie.controller;


import com.capston.v2psmombie.dto.UserCreateDto;
import com.capston.v2psmombie.dto.UserUpdateDto;
import com.capston.v2psmombie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 사용자 정보 수정
     **/
    @PatchMapping("/users/{deviceId}")
    public ResponseEntity<String> update(
            @PathVariable String deviceId,
            @RequestBody UserUpdateDto dto
    ) {
        try {
            String updatedDeviceId = userService.update(deviceId, dto);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("[SUCCESS] 사용자 데이터 수정: " + updatedDeviceId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("[FAIL] 사용자 데이터 수정: " + e.getMessage());
        }
    }


    /**
     * 사용자 삭제
     **/
    @DeleteMapping("/users/{deviceId}")
    public ResponseEntity<String> delete(@PathVariable String deviceId) {
        try {
            String delUserDeviceId = userService.delete(deviceId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("[SUCCESS] 사용자 삭제: " + delUserDeviceId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("[FAIL] 사용자 삭제: " + e.getMessage());
        }
    }

}
