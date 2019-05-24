package com.djyz.domain;

import lombok.Data;

@Data
public class ShootingLocation {
    private Long lid;

    private String lname;

    private Long shootingDays;

    private Long timeLimit;

    private ComboLocation comboLocation;

}