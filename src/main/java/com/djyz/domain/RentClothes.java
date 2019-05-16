package com.djyz.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class RentClothes {
    private Long cloId;
    private String cloName;
    private Double cloPrice;
    private String cloPicture;
    private String cloDetail;
    private Long cloType;


}