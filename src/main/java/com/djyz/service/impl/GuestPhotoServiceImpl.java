package com.djyz.service.impl;

import com.djyz.domain.GuestPhoto;
import com.djyz.mapper.GuestPhotoMapper;
import com.djyz.service.GuestPhotoService;
import com.djyz.util.AjaxRes;
import com.djyz.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GuestPhotoServiceImpl implements GuestPhotoService {
    @Autowired
    private GuestPhotoMapper guestPhotoMapper;
    @Autowired
    private FileUpload fileUpload;

    /*获取全部客照*/
    @Override
    public List<GuestPhoto> getAllGuestPhoto() {
        return guestPhotoMapper.selectAll();
    }

    /*上传客照*/
    @Override
    public AjaxRes addGuestPhoto(GuestPhoto guestPhoto, MultipartFile[] files, HttpSession session) {
        AjaxRes ajaxRes = new AjaxRes();
        ArrayList<String> filenames = new ArrayList<>();
        try {
            if(files != null || !"".equals(files)){
                for (MultipartFile file : files) {
                    //上传图片
                    String filename = fileUpload.upload(file, session);
                    filenames.add(filename);
                }
                guestPhoto.setGuPic1(filenames.get(0));
                guestPhoto.setGuPic2(filenames.get(1));
                guestPhoto.setGuPic3(filenames.get(2));
                guestPhoto.setGuPic4(filenames.get(3));
                guestPhoto.setGuPic5(filenames.get(4));
                guestPhoto.setGuPic6(filenames.get(5));
                guestPhoto.setGuPic7(filenames.get(6));
                guestPhoto.setGuPic8(filenames.get(7));
                guestPhoto.setGuPic9(filenames.get(8));
                guestPhoto.setGuPic10(filenames.get(9));
            }
            System.out.println("guestPhoto-------------"+guestPhoto);
            //保存客照
            guestPhotoMapper.insert(guestPhoto);

            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }


}
