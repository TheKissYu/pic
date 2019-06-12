package com.yuhaoze.service;

import com.yuhaoze.entity.Picture;
import com.yuhaoze.vo.JsonData;
import com.yuhaoze.vo.PageVo;

import java.util.Map;

public interface PictureService {
    PageVo getPicByClassic(int classicId, int page, int limit);
    JsonData addPicture(Picture picture);
    Picture getPicByPid(int id);
    JsonData addDownloadCount(int pid);
    PageVo getTopBy(int lim);
    JsonData deletePicture(int pid, int uid);
    PageVo getAll(int page, int limit);
    PageVo getTopByCid(int cid, int limit);
    PageVo selectPsByMap(int status, int uid, int page, int limit);
    PageVo selectPsByUid(int uid, int page, int limit);
}
