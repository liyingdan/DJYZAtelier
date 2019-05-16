package com.djyz.web;

import com.djyz.domain.GuestPhoto;
import com.djyz.service.GuestPhotoService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(value = "/GuestPhoto", tags = "GuestPhoto接口")
public class GuestPhotoController {
    @Autowired
    private GuestPhotoService guestPhotoService;

    /*获取全部客照*/
    @GetMapping("/getAllGuestPhoto")
    @ResponseBody
    public List<GuestPhoto> getAllGuestPhoto(){
        return guestPhotoService.getAllGuestPhoto();
    }

    /*增加客照*/
    @PostMapping("/addGuestPhoto")
    @ResponseBody
    public AjaxRes addGuestPhoto(GuestPhoto guestPhoto, @PathVariable MultipartFile[] files, HttpSession session){
        return guestPhotoService.addGuestPhoto(guestPhoto,files,session);
    }
}
