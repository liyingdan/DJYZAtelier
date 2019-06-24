package com.djyz.service;

import com.djyz.domain.Customer;
import com.djyz.util.AjaxRes;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;

import java.util.List;

public interface CustomerService {

    AjaxRes addCustomer(Customer customer);

    PageList getAllCustomer(QueryVo vo);

    AjaxRes customerLogin(Customer customer);


    Customer getCustomerWithId(Long custId);


    AjaxRes addHeader(String headerPic);

    AjaxRes editCustomer(Customer customer);

    AjaxRes deleteCustomer(Long custId);
}
