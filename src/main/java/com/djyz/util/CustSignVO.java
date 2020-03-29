package com.djyz.util;

import com.djyz.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.PhantomReference;

/**
 * @author liyingdan
 * @date 2020/3/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustSignVO {
    private boolean success;
    private String msg;
    private Customer customer;
    private String token;
}
