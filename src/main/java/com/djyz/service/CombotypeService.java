package com.djyz.service;

import com.djyz.domain.Combotype;
import com.djyz.util.AjaxRes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CombotypeService {
    List<Combotype> getAllCombotype();

    AjaxRes addCombotype(String tname, String tdec, MultipartFile file, HttpSession session);


    Combotype getCombotypeWithId(Long tid);

    AjaxRes editCombotype(Long tid, String tname, String tdec, MultipartFile file, HttpSession session);
}
