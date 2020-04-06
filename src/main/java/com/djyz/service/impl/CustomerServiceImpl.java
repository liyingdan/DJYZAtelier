package com.djyz.service.impl;

import com.djyz.domain.Customer;
import com.djyz.domain.RentClothes;
import com.djyz.mapper.CustomerMapper;
import com.djyz.service.CustomerService;
import com.djyz.service.RedisService;
import com.djyz.util.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RedisService redisService;

    /*注册，添加用户*/
    @Override
    public AjaxRes addCustomer(Customer customer) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            customerMapper.insert(customer);
            ajaxRes.setCustomer(customer);
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*查询所有客户---分页*/
    @Override
    public PageList getAllCustomer(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPageNum(), vo.getRows());

        List<Customer> customers = customerMapper.selectAll();

        /*分装pageList*/
        PageList pageList = new PageList();
        pageList.setTotal(page.getTotal());
        pageList.setRows(customers);

        return pageList;

    }

    /*客户登录*/
    @Override
    public AjaxRes customerLogin(Customer customer) {
        AjaxRes ajaxRes = new AjaxRes();
        try{
            Customer customer1 = customerMapper.customerLogin(customer);
            if(customer1 != null){
                //登录成功，生成 token
                String token = CommonUtil.generateToken();
                String normalKey = "cust_"+customer1.getCustId();
                //存到redis中
                Boolean saveRedis = redisService.saveNormalStringKeyValue(normalKey, token, 300);
                if (!saveRedis){
                    ajaxRes.setSuccess(false);
                    ajaxRes.setMsg("存入redis失败");
                    return ajaxRes;
                }

                ajaxRes.setToken(token);
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
        }finally {
            return ajaxRes;
        }

    }


    /*根据id查询客户*/
    @Override
    public Customer getCustomerWithId(Long custId) {
        return customerMapper.selectByPrimaryKey(custId);
    }

    /*修改个人资料*/
    @Override
    public AjaxRes editCustomer(Customer customer) {
        String password = customer.getPassword();
        String custName = customer.getCustName();
        String headerPic = customer.getHeaderPic();

        AjaxRes ajaxRes = new AjaxRes();
        Customer selectCustomer = customerMapper.selectByPrimaryKey(customer.getCustId());
        System.out.println("selectCustomer----------------"+selectCustomer);
        try {
            //更新头像
            if(headerPic != null && !"".equals(headerPic)){
                selectCustomer.setHeaderPic(headerPic);
            }
            //修改用户名
            if(custName != null && !"".equals(custName)){
                selectCustomer.setCustName(custName);
            }
            //修改密码
            if(password != null && !"".equals(password)){
                selectCustomer.setPassword(password);
            }

            System.out.println("要插入修改的的数据---------------"+selectCustomer);
            customerMapper.updateByPrimaryKey(selectCustomer);

            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*根据id删除客户*/
    @Override
    public AjaxRes deleteCustomer(Long custId) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            customerMapper.deleteByPrimaryKey(custId);
            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*用户退出登录*/
    @Override
    public AjaxRes custLogout(Long custId) {
        AjaxRes ajaxRes = new AjaxRes();
        try {
            //在 redis 中删除 token
            String normalKey = "cust_" + custId;
            redisService.removeByKey(normalKey);

            ajaxRes.setSuccess(true);
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
}
