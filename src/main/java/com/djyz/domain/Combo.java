package com.djyz.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Combo {
    private Long coId;

    private String coName;

//    private Double coPrice;

    private String coPicture;

    private Long coType;

    private String coDays;

    private String detailPic1;

    private String detailPic2;

    private String detailPic3;

    private String detailPic4;

    private String detailPic5;

    private List<ShootingLocation> shootingLocations = new ArrayList<>();

}