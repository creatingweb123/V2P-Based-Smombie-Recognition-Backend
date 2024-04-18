package com.capston.v2psmombie.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ap")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Ap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ap_id")
    private Integer id;

    @Column(name = "ap_name")
    private String name;

    private double latitude;
    private double longitude;


    @Builder
    public Ap(
            String name,
            double latitude,
            double longitude
    ) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static ApBuilder builder(String name) {
        ApBuilder apBuilder = new ApBuilder();
        apBuilder.name(name);
        return apBuilder;
    }
}
