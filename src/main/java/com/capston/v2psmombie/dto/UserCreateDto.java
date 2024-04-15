package com.capston.v2psmombie.dto;

import com.capston.v2psmombie.domain.User;
import lombok.Getter;

@Getter
public class UserCreateDto {

    private String deviceId;
    private Boolean mode;

    public User toUserEntity() {
        return User.builder(
                this.getDeviceId(), this.getMode()
        ).build();
    }
}

