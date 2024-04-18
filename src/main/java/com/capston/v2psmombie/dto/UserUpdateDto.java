package com.capston.v2psmombie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        title = "UserUpdateDto: User 수정 요청 DTO",
        description = "User update request DTO")
public class UserUpdateDto {

    @Schema(description = "사용자 위치 위도", example = "37.5541234")
    private double latitude;

    @Schema(description = "사용자 위치 경도", example = "126.9712345")
    private double longitude;

    @Schema(description = "사용자 속도", example = "56.34")
    private double speed;

    @Schema(description = "사용자 방향", example = "9.8")
    private double direction;

    @Schema(description = "사용자 모드(차량:true, 보행자:false)", example = "false")
    private Boolean mode;

    @Schema(description = "스몸비 여부", example = "true")
    private Boolean smombie;

    @Schema(description = "연결된 AP 이름", example = "CTkyLjE2OC4xMjMuMTMyMDA6MTE6MjI6MzM6NDQ6NTUK")
    private String apName;
}
