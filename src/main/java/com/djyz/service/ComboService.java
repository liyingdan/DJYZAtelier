package com.djyz.service;

import com.djyz.domain.Combo;
import com.djyz.util.AjaxRes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ComboService {
    AjaxRes addCombo(Combo combo, MultipartFile[] files, MultipartFile smPicture, HttpSession session);

    List<Combo> getAllCombo();

    Combo getComboWithId(Long coId);
}
