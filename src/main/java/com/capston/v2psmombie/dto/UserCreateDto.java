package com.capston.v2psmombie.dto;

import com.capston.v2psmombie.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(
        title = "UserCreateDto: User 생성 요청 DTO",
        description = "User create request DTO")
public class UserCreateDto {

    @Schema(description = "사용자 디바이스 ID", example = "b8581580-f97e-11ee-af4b-490ac169fde7")
    private String deviceId;

    @Schema(description = "사용자 모드(차량:true, 보행자:false)", example = "true")
    private Boolean mode;

    public User toUserEntity() {
        return User.builder(
                this.getDeviceId(), this.getMode()
        ).build();
    }
}

