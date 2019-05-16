package com.djyz.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter@Getter@ToString
public class ClothesType {
    private Long cloTypeId;
    private String cloTypeName;
    private List<RentClothes> rentClothes;

}