package com.djyz.service;

import com.djyz.domain.Customer;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface CustomerService {

    AjaxRes addCustomer(Customer customer);

    List<Customer> getAllCustomer();

    AjaxRes customerLogin(Customer customer);


    Customer getCustomerWithId(Long custId);


    AjaxRes addHeader(String headerPic);

    AjaxRes editCustomer(Customer customer);
}
