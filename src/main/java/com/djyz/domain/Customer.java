package com.djyz.domain;

import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class Customer {
    private Long custId;
    private String custName;
    private String password;
    private String custPhone;
    private String address;
    private String headerPic;
}