package com.capston.v2psmombie.dto;

import lombok.Getter;

@Getter
public class UserUpdateDto {
    private double latitude;
    private double longitude;
    private double speed;
    private double direction;
    private Boolean mode;
    private Boolean smombie;
    private String apName;
}
