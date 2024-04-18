package com.capston.v2psmombie.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Schema(
        title = "LocationDto: User 위치 DTO",
        description = "User location DTO")
public class LocationDto {

    @Schema(description = "위도", example = "37.554")
    private double latitude;

    @Schema(description = "경도", example = "126.97")
    private double longitude;
}
