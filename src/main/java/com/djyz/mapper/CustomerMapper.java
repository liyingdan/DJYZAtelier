package com.djyz.mapper;

import com.djyz.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    Customer selectByPrimaryKey(Long custId);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);

    Customer customerLogin(Customer customer);
}