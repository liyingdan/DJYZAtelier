package com.djyz.service;

import com.djyz.domain.Combo;
import com.djyz.util.AjaxRes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ComboService {
    AjaxRes addCombo(Combo combo);

    List<Combo> getAllCombo();

    Combo getComboWithId(Long coId);

    List<Combo> getCombosWithAid(Long tid);

    AjaxRes deleteCombosWith(Long comOrderId);
}
