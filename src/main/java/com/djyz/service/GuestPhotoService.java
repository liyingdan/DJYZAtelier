package com.djyz.service;

import com.djyz.domain.GuestPhoto;
import com.djyz.util.AjaxRes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface GuestPhotoService {
    AjaxRes addGuestPhoto(GuestPhoto guestPhoto, MultipartFile[] files, HttpSession session);

    List<GuestPhoto> getAllGuestPhoto();
}
