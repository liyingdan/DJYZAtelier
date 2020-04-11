package com.djyz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class ComboOrder {
    private Long comOrderId;

    private Double price;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date comOderDate;

    private String startDate;

    private Combo combo;

    private Customer customer;

    private ShootingLocation shootingLocation;

    private  ComboOrderState comboOrderState;

    private String comboOrderProducts;




}