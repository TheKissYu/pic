package com.yuhaoze.service.impl;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUnlockTablesStatement;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuhaoze.dao.PictureMapper;
import com.yuhaoze.entity.Picture;
import com.yuhaoze.service.PictureService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;
    @Override
    public PageVo getPicByClassic(int classicId, int page, int limit) {

        PageVo pageVo = new PageVo();
        try{
            PageHelper.startPage(page, limit);
            List<PictureVo> list = pictureMapper.getPicByCid(classicId);
            PageInfo<PictureVo> pictureVos = new PageInfo<>(list);

            System.out.println(list);
            pageVo = MyUtils.getOK(pictureVos.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            pageVo = MyUtils.getErr(e);
        }

        return pageVo;
    }

    @Override
    public JsonData addPicture(Picture picture) {
        int flag = pictureMapper.insertSelective(picture);
        if(flag > 0){
            return MyUtils.getDate("上传成功");
        }
        return MyUtils.noDate();
    }

    @Override
    public Picture getPicByPid(int id) {
        return pictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsonData addDownloadCount(int pid) {
        try{
            pictureMapper.addDownloadCount(pid);
            return MyUtils.setAll(1,"+1");
        } catch (Exception e){
            return MyUtils.noDate();
        }
    }

    @Override
    public PageVo getTopBy(int count) {
        List<PicDownloadVo> list = pictureMapper.getByDownloadCount(count);

        return MyUtils.getOK(count,list);
    }

    @Override
    public JsonData deletePicture(int pid, int uid) {
        Picture picture = pictureMapper.selectByPrimaryKey(pid);
        if(uid == picture.getUserid()){
            Map<String,Integer> map = new HashMap<>();
            map.put("pictureStatus",3);
            map.put("pictureid",pid);
            pictureMapper.updateStatus(map);
            return MyUtils.getDate("删除成功");
        }
        return MyUtils.noDate();
    }

    @Override
    public PageVo getAll(int page, int limit) {
        PageVo pageVo = new PageVo();
        try{
            PageHelper.startPage(page, limit);
            List<PictureVo> list = pictureMapper.getAll();
            PageInfo<PictureVo> pictureVos = new PageInfo<>(list);
            pageVo = MyUtils.getOK(pictureVos.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            pageVo = MyUtils.getErr(e);
        }

        return pageVo;
    }

    @Override
    public PageVo getTopByCid(int cid, int limit) {
        Map<String,Integer> map = new HashMap<>();
        map.put("cid",cid);
        map.put("lim",limit);
        List<PicDownloadVo> list = pictureMapper.getTopByCid(map);

        return MyUtils.getOK(limit,list);
    }

    @Override
    public PageVo selectPsByMap(int status, int uid,int page, int limit) {

        PageVo pageVo = new PageVo();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("status",status);
        map.put("uid",uid);
        try{
            PageHelper.startPage(page, limit);
            List<PicStVo> list = pictureMapper.getByStAndUid(map);
            PageInfo<PicStVo> pictureVos = new PageInfo<>(list);

            System.out.println(list);
            pageVo = MyUtils.getOK(pictureVos.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            pageVo = MyUtils.getErr(e);
        }

        return pageVo;
    }

    @Override
    public PageVo selectPsByUid(int uid, int page, int limit) {
        PageVo pageVo = new PageVo();

        try{
            PageHelper.startPage(page, limit);
            List<PicStVo> list = pictureMapper.getPsByUid(uid);
            PageInfo<PicStVo> pictureVos = new PageInfo<>(list);

            System.out.println(list);
            pageVo = MyUtils.getOK(pictureVos.getTotal(),list);
        }catch (Exception e){
            e.printStackTrace();
            pageVo = MyUtils.getErr(e);
        }

        return pageVo;
    }


}
