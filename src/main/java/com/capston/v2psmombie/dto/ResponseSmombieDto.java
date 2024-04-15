package com.capston.v2psmombie.dto;

import com.capston.v2psmombie.domain.User;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseSmombieDto {

    private Integer riskLevel;
    private List<LocationDto> smombiesLocation;

    public ResponseSmombieDto(Integer riskLevel, List<User> users) {
        this.riskLevel = riskLevel;
        this.smombiesLocation = createLocations(users);
    }

    private List<LocationDto> createLocations(List<User> users) {
        return users.stream()
                .map(user -> new LocationDto(
                        user.getLatitude(),
                        user.getLongitude()))
                .toList();
    }
}
