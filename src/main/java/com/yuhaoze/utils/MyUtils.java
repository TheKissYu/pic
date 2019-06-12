package com.yuhaoze.utils;

import com.yuhaoze.entity.Login;
import com.yuhaoze.service.LoginService;
import com.yuhaoze.vo.JsonData;
import com.yuhaoze.vo.PageVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;

public class MyUtils {
    private static JsonData jsonData = new JsonData();
    public static JsonData getDate(Object data){
        jsonData.setCode(1);
        jsonData.setData(data);
        return jsonData;
    }
    public static JsonData setAll(int i,Object data){
        jsonData.setCode(i);
        jsonData.setData(data);
        return jsonData;
    }
    public static JsonData noDate(){
        jsonData.setCode(0);
        jsonData.setData(null);
        return jsonData;
    }
    public static boolean isPicture(File file){
        try {
            // 通过ImageReader来解码这个file并返回一个BufferedImage对象
            // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
            // 或者在解析过程中报错，也返回false
            Image image = ImageIO.read(file);
            return image != null;
        } catch(IOException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    public static String getSuffix(String str){
        int i = str.lastIndexOf(".");
        if (i > 0) {
           return str.substring(i+1);
        }
        return null;
    }

    public static ResponseEntity<byte[]> buildResponseEntity(File file,String name) throws IOException {
        byte[] body = null;
        //获取文件
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        //设置文件类型
        headers.add("Content-Disposition", "attchement;filename=" + name);
        //设置Http状态码
        HttpStatus statusCode = HttpStatus.OK;
        //返回数据
         ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
    public static void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    private static PageVo pageVo = new PageVo();
    public static PageVo getOK(long count,Object data){
        pageVo.setCode(0);
        pageVo.setCount(count);
        pageVo.setData(data);
        return pageVo;
    }
    public static PageVo getErr(Exception e){
        pageVo.setCode(1);
        pageVo.setMsg(e.getMessage());
        return pageVo;
    }
    public static Boolean eqUid(HttpSession session, LoginService loginService){
        Object uid = session.getAttribute("uid");
        if(uid != null &&!"".equals(uid.toString())) {
            int i = (int) uid;
            Login login = loginService.getByUid(i);
            if (login!=null&&login.getIsLogin() == 1){
                return true;
            }

        }
        return false;
    }
}
