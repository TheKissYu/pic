package com.yuhaoze.dao;

import com.yuhaoze.entity.Picture;
import com.yuhaoze.vo.PicDownloadVo;
import com.yuhaoze.vo.PicStVo;
import com.yuhaoze.vo.PictureInfo;
import com.yuhaoze.vo.PictureVo;

import java.util.List;
import java.util.Map;

public interface PictureMapper {
    int deleteByPrimaryKey(Integer pictureid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer pictureid);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

    List<PictureVo> getPicByCid(int cid);

    List<PictureVo> getAll();
    int addDownloadCount(int pid);


    List<PicDownloadVo> getByDownloadCount(int lim);
    List<PicDownloadVo> getTopByCid(Map<String, Integer> map);
    //0 图片审核中
    // 1图片审核未通过
    // 2图片审核通过
    // 3图片已删除

    /**
     *
     * @param map
     * pictureStatus 0 图片审核中 1图片审核未通过 2图片审核通过 3图片已删除
     * pictureid pid
     * @return
     */
    int updateStatus(Map<String, Integer> map);

    /**
     *
     * @param map
     * uid status
     * @return
     */
    List<PicStVo> getByStAndUid(Map<String, Integer> map);
    List<PicStVo> getBySt(int status);
    List<PicStVo> getPsByUid(int uid);
}