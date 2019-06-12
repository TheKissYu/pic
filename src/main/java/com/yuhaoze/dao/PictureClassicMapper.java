package com.yuhaoze.dao;

import com.yuhaoze.entity.PictureClassic;

import java.util.List;
import java.util.Map;

public interface PictureClassicMapper {
    int deleteByPrimaryKey(Integer picClassicId);

    int insert(PictureClassic record);

    int insertSelective(PictureClassic record);

    PictureClassic selectByPrimaryKey(Integer picClassicId);

    int updateByPrimaryKeySelective(PictureClassic record);

    int updateByPrimaryKey(PictureClassic record);

    List<Map<Integer,String>> getAllPicClassic();

}