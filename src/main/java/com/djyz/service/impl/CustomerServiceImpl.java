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

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private FileUpload fileUpload;


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
//                String token = CommonUtil.generateToken();
//                String normalKey = "cust_"+customer1.getCustId();
                //存到redis中
//                Boolean saveRedis = redisService.saveNormalStringKeyValue(normalKey, token, 300);
//                if (!saveRedis){
//                    ajaxRes.setSuccess(false);
//                    return ajaxRes;
//                }

//                ajaxRes.setToken(token);
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

    /*上传照片*/
//    @Override
//    public AjaxRes addHeader(String headerPic) {
//        AjaxRes ajaxRes = new AjaxRes();
//        try {
//            Customer customer = new Customer();
//            customer.setHeaderPic(headerPic);
//            customerMapper.updateByPrimaryKey(customer);
//            ajaxRes.setSuccess(true);
//        } catch (Exception e) {
//            ajaxRes.setSuccess(false);
//        }
//        return ajaxRes;
//
//    }

    /*修改个人资料*/
    @Override
    public AjaxRes editCustomer(Long custId, String custName, String password, MultipartFile headerPic, HttpSession session) {
        AjaxRes ajaxRes = new AjaxRes();
        Customer newCustomer = new Customer();
        Customer selectCustomer1 = customerMapper.selectByPrimaryKey(custId);
        try {
            //更新头像----如果file不为空，删除之前上传到服务器的图片，然后再上传新的图片
            if(headerPic != null || !"".equals(headerPic)){
                String oldPic = selectCustomer1.getHeaderPic();
                //删除
                fileUpload.deleteFile(oldPic,session);
                //上传新的图片
                String filename = fileUpload.upload(headerPic, session);
                newCustomer.setHeaderPic(filename);
            }
            //修改用户名
            if(custName != null || !"".equals(custName))
                newCustomer.setCustName(custName);
            //修改密码
            if(password != null || !"".equals(password))
                newCustomer.setCustName(password);
            customerMapper.updateByPrimaryKey(newCustomer);

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

    /*上传头像 */
//    @Override
//    public AjaxRes saveHeadPic(Long custId, String headPicPath) {
//        AjaxRes ajaxRes = new AjaxRes();
//        try {
//            Customer customer = customerMapper.selectByPrimaryKey(custId);
//            customer.setHeaderPic(headPicPath);
//            customerMapper.updateByPrimaryKey(customer);
//
//            ajaxRes.setSuccess(true);
//        } catch (Exception e) {
//            ajaxRes.setSuccess(false);
//        }
//        return ajaxRes;
//
//    }


}
