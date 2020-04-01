package com.djyz.service;

import com.djyz.domain.Customer;
import com.djyz.util.AjaxRes;
import com.djyz.util.CustSignVO;
import com.djyz.util.PageList;
import com.djyz.util.QueryVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CustomerService {

    AjaxRes addCustomer(Customer customer);

    PageList getAllCustomer(QueryVo vo);

    AjaxRes customerLogin(Customer customer);


    Customer getCustomerWithId(Long custId);


//    AjaxRes addHeader(String headerPic);

    AjaxRes editCustomer(Long custId, String custName, String password, MultipartFile headerPic, HttpSession session);

    AjaxRes deleteCustomer(Long custId);

//    AjaxRes saveHeadPic(Long custId, String headPicPath);
}
