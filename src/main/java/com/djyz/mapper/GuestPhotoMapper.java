package com.djyz.mapper;

import com.djyz.domain.GuestPhoto;
import java.util.List;

public interface GuestPhotoMapper {
    int deleteByPrimaryKey(Long guId);

    int insert(GuestPhoto record);

    GuestPhoto selectByPrimaryKey(Long guId);

    List<GuestPhoto> selectAll();

    int updateByPrimaryKey(GuestPhoto record);
}