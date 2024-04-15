package com.capston.v2psmombie.controller;

import com.capston.v2psmombie.domain.Ap;
import com.capston.v2psmombie.dto.ApCreateDto;
import com.capston.v2psmombie.service.ApService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApController {

    private final ApService apService;


    /**
     * Ap 등록
     **/
    @PostMapping("/ap")
    public ResponseEntity<String> createAp(@RequestBody ApCreateDto dto) {
        try {
            Ap createdAp = apService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("[SUCCESS] AP 생성: " + createdAp.getName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("[FAIL] AP 생성: " + e.getMessage());
        }
    }

}

