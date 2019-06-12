package com.yuhaoze.controller;

import com.yuhaoze.entity.Picture;
import com.yuhaoze.service.PicDownloadService;
import com.yuhaoze.service.PictureClassicService;
import com.yuhaoze.service.PictureService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.JsonData;
import com.yuhaoze.vo.PageVo;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/picLogin")
public class PictureLoginController {
    @Autowired
    private PictureClassicService pictureClassicService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PicDownloadService picDownloadService;
    @PostMapping("/upload")
    public JsonData uploadPicture(@RequestParam("file") MultipartFile file, int cid,String picName,
                                  HttpServletRequest request){
        Object o = request.getSession().getAttribute("uid");

        Picture picture = new Picture();
        picture.setCreatTime(new Date());
        try{
            int uid = (int) o;
            picture.setUserid(uid);
        }catch (Exception e){
            System.out.println("error");
        }
        picture.setPictureName(picName);
        picture.setPictureStatus(0);
        picture.setPictureClassicId(cid);
        if (!file.isEmpty()){
            CommonsMultipartFile cf= (CommonsMultipartFile)file;
            DiskFileItem fi = (DiskFileItem)cf.getFileItem();

            File f = fi.getStoreLocation();
            if (!MyUtils.isPicture(f)){
                return MyUtils.getDate("文件不为图片");
            }
            String contextPath = request.getContextPath();

            String servletPath = request.getServletPath();
            String scheme  = request.getScheme();
//            String storePath= "E:\\upload";//存放我们上传的文件路径
            String storePath= "/usr/local/upload";
            String fileName = file.getOriginalFilename();
            if(fileName.length()>50){
                return MyUtils.setAll(0,"图片名太长");
            }
            UUID uuid = UUID.randomUUID();
            String tempName = uuid+"." +MyUtils.getSuffix(fileName);
            picture.setPicturePath(tempName);
            System.out.println(tempName);
            File filepath = new File(storePath, tempName);

            if (!filepath.getParentFile().exists()) {

                filepath.getParentFile().mkdirs();//如果目录不存在，创建目录

            }
            try {
                file.transferTo(new File(storePath + File.separator + tempName));//把文件写入目标文件地址
                pictureService.addPicture(picture);
            } catch (Exception e) {

                e.printStackTrace();

                return MyUtils.getDate("上传失败");

            }

            return MyUtils.getDate("success");//返回到成功页面
        }else {

            return MyUtils.getDate("error");//返回到失败的页面
        }
    }
    @RequestMapping("/deletePic")
    public JsonData deletePic(int pid,int uid){
        return pictureService.deletePicture(pid, uid);
    }
    @RequestMapping("/getBySi")
    public PageVo getBySi(int status, int page, int limit, HttpSession session){

        try{
            int uid = (int) session.getAttribute("uid");
            if(status==-1){
                return pictureService.selectPsByUid(uid,page,limit);
            }
            return pictureService.selectPsByMap(status,uid,page,limit);
        }catch (Exception e){
            return MyUtils.getErr(e);
        }
    }
    @RequestMapping("/getByUid")
    public PageVo getByUid(int page, int limit, HttpSession session){
        try{
            int uid = (int) session.getAttribute("uid");
            return pictureService.selectPsByUid(uid,page,limit);
        }catch (Exception e){
            return MyUtils.getErr(e);
        }
    }
}
