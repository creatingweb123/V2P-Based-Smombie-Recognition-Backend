package com.capston.v2psmombie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(title = "ApCreateDto: AP 생성 요청 DTO")
public class ApCreateDto {

    @Schema(description = "AP 이름", example = "CTkyLjE2OC4xMjMuMTMyMDA6MTE6MjI6MzM6NDQ6NTUK")
    private String name;

    @Schema(description = "AP 설치 위도", example = "37.5440000")
    private double latitude;

    @Schema(description = "AP 설치 경도", example = "126.9800000")
    private double longitude;
}
