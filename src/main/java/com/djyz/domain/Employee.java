package com.djyz.domain;

import lombok.Data;

@Data
public class Employee {
    private Long eid;

    private String username;

    private String password;

//    private Long rid;
    private Role role;


}