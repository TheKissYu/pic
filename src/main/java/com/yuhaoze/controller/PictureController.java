package com.yuhaoze.controller;
import com.yuhaoze.entity.Picture;
import com.yuhaoze.service.LoginService;
import com.yuhaoze.service.PicDownloadService;
import com.yuhaoze.service.PictureClassicService;
import com.yuhaoze.service.PictureService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.JsonData;
import com.yuhaoze.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author 余昊泽
 */
@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureClassicService pictureClassicService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PicDownloadService picDownloadService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/picClassic")
    public JsonData getPicClassic(){
        return pictureClassicService.getAllClassic();
    }
    @GetMapping("/pictureByClassic")
    public PageVo getPicByClassic(int classicId, int page, int limit){
        if (classicId == -1){
            return pictureService.getAll(page,limit);
        }
        return pictureService.getPicByClassic(classicId,page,limit);
    }
    @GetMapping("/getAll")
    public PageVo getAll(int page, int limit){
        return  pictureService.getAll(page,limit);
    }

    @GetMapping("/downloadPic")
    public ResponseEntity<byte[]> downloadPicture(int pid, HttpSession session) throws IOException {
        Object o = session.getAttribute("uid");
        if(MyUtils.eqUid(session,loginService)){
            picDownloadService.add(pid,(int)o);
        }
        Picture picture = pictureService.getPicByPid(pid);
        String fileName = picture.getPicturePath();
        int rex = fileName.lastIndexOf(".");
        String s = fileName.substring(rex);
        System.out.println(s);
//        File file = new File("E:\\upload",fileName);
        File file = new File("/usr/local/upload",fileName);
        pictureService.addDownloadCount(pid);
        return MyUtils.buildResponseEntity(file,picture.getPictureName()+s);
    }
    @RequestMapping("/showPic")
    public void showPic(String pid, HttpServletResponse response){
        int id = 0;
        try{
            id = Integer.valueOf(pid);
            Picture picture = pictureService.getPicByPid(id);
            String fileName = picture.getPicturePath();
//            File img = new File("E:\\upload",fileName);
            File img = new File("/usr/local/upload",fileName);
            MyUtils.responseFile(response,img);
        }catch (Exception e){
            System.out.println("error");
        }
    }
    @GetMapping("/top")
    public PageVo getTop(int limit){
        return pictureService.getTopBy(limit);
    }
    @GetMapping("/topByCid")
    public PageVo getTop(int limit,int classicId){
        if(classicId == -1){
            return getTop(limit);
        }
        return pictureService.getTopByCid(classicId,limit);
    }
    @GetMapping("/MyDownload")
    public PageVo getMyDownload(int page ,int limit ,HttpSession session){
        try {
                return picDownloadService.getMyDownloadLog((int) session.getAttribute("uid"),page,limit);
        }catch (Exception e){
            e.printStackTrace();
            return MyUtils.getErr(e);
        }
    }
}
