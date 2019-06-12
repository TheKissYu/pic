package com.yuhaoze.dao;

import com.yuhaoze.entity.PicDownload;
import com.yuhaoze.vo.PicDownloadVo;

import java.util.List;

public interface PicDownloadMapper {
    int deleteByPrimaryKey(Integer downloadid);

    int insert(PicDownload record);

    int insertSelective(PicDownload record);

    PicDownload selectByPrimaryKey(Integer downloadid);

    int updateByPrimaryKeySelective(PicDownload record);

    int updateByPrimaryKey(PicDownload record);

    List<PicDownload> selectPdByUid(int uid);

    List<PicDownloadVo> selectMyAllDownload(int uid);
    List<PicDownloadVo> selectMyAllDownload1(int uid);
}