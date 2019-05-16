package com.djyz.domain;

import lombok.Data;

@Data
public class ShootingLocation {
    private Long lid;

    private String lname;

    private ComboLocation comboLocation;

}