package com.yuhaoze.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuhaoze.dao.PicDownloadMapper;
import com.yuhaoze.entity.PicDownload;
import com.yuhaoze.service.PicDownloadService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.PageVo;
import com.yuhaoze.vo.PicDownloadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicDownloadServiceImpl implements PicDownloadService {

    @Autowired
    private PicDownloadMapper picDownloadMapper;
    @Override
    public int add(int pid, int uid) {
        PicDownload picDownload = new PicDownload();
        picDownload.setPcitureid(pid);
        picDownload.setUserid(uid);
        return picDownloadMapper.insertSelective(picDownload);
    }

    @Override
    public PageVo getMyDownloadLog(int uid, int page, int limit) {
        PageVo pageVo = new PageVo();
        try{
            PageHelper.startPage(page,limit);
            List<PicDownloadVo> list = picDownloadMapper.selectMyAllDownload(uid);
            PageInfo<PicDownloadVo> pictureVos = new PageInfo<>(list);
            pageVo = MyUtils.getOK(pictureVos.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            pageVo = MyUtils.getErr(e);
        }
        return pageVo;
    }

    @Override
    public PageVo getMyDownloadLog1(int uid, int page, int limit) {
        PageVo pageVo = new PageVo();
        try{
            PageHelper.startPage(page,limit);
            List<PicDownloadVo> list = picDownloadMapper.selectMyAllDownload1(uid);
            PageInfo<PicDownloadVo> pictureVos = new PageInfo<>(list);
            pageVo = MyUtils.getOK(pictureVos.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            pageVo = MyUtils.getErr(e);
        }
        return pageVo;
    }
}
