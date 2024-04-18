package com.capston.v2psmombie.controller;

import com.capston.v2psmombie.domain.Ap;
import com.capston.v2psmombie.dto.ApCreateDto;
import com.capston.v2psmombie.service.ApService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Tag(name = "Ap", description = "Ap 관련 REST API에 대한 명세")
public class ApController {

    private final ApService apService;


    /**
     * Ap 등록
     **/
    @PostMapping("/ap")
    @Operation(summary = "Ap 생성(create)", description = "Ap를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "[SUCCESS] AP 생성"),
            @ApiResponse(responseCode = "400", description = "[FAIL] AP 생성")
    })
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

