package com.djyz.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ComboOrder {
    private Long comOrderId;

    private Double price;

    private Date comOderDate;

    private Date startDate;

//    private Long comboId;
    private Combo combo;

//    private Long customerId;
    private Customer customer;

//    private Long shoottingLocationId;
    private ShootingLocation shootingLocation;

    private Byte shootingState;


}