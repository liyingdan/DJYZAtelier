package com.djyz.service.impl;

import com.djyz.domain.Customer;
import com.djyz.mapper.CustomerMapper;
import com.djyz.service.CustomerService;
import com.djyz.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public AjaxRes addCustomer(Customer customer) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            customerMapper.insert(customer);
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.selectAll();
    }

    /*登录*/
    @Override
    public AjaxRes customerLogin(Customer customer) {
//        System.out.println("service中-----------------customer--"+customer);
        AjaxRes ajaxRes = new AjaxRes();
        //登录验证1
        try{
            Customer customer1 = customerMapper.customerLogin(customer);
//            System.out.println("登录---------------"+customer1);
            if(customer1 != null){
//                System.out.println("登录成功------------------"+customer1);
                ajaxRes.setSuccess(true);
                ajaxRes.setMsg("登录成功");
                ajaxRes.setCustomer(customer1);
            }
            else {
                ajaxRes.setSuccess(false);
                ajaxRes.setMsg("用户名或密码不正确");
            }
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("用户名或密码不正确");
        }
        return ajaxRes;
    }


    /*根据id查询客户*/
    @Override
    public Customer getCustomerWithId(Long custId) {
        return customerMapper.selectByPrimaryKey(custId);
    }

    /*修改个人资料*/

}
