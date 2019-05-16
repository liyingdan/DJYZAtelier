package com.djyz.service.impl;

import com.djyz.domain.ComboOrder;
import com.djyz.mapper.ComboOrderMapper;
import com.djyz.service.ComboOrderService;
import com.djyz.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComboOrderServiceImpl implements ComboOrderService {
    @Autowired
    private ComboOrderMapper comboOrderMapper;

    @Override
    public List<ComboOrder> getAllComboOrders() {
        return comboOrderMapper.selectAll();
    }

    @Override
    public AjaxRes addComboOrders(ComboOrder comboOrder) {
        return null;
    }
}
