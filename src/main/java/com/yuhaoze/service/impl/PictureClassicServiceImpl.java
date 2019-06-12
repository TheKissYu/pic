package com.yuhaoze.service.impl;

import com.yuhaoze.dao.PictureClassicMapper;
import com.yuhaoze.service.PictureClassicService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PictureClassicServiceImpl implements PictureClassicService {
   @Autowired
   private PictureClassicMapper pictureClassicMapper;

   @Override
   public JsonData getAllClassic() {
      JsonData jsonData =new JsonData();
      try {
         List<Map<Integer,String>> list = pictureClassicMapper.getAllPicClassic();
         jsonData = MyUtils.getDate(list);
      } catch (Exception e){
         e.printStackTrace();
         jsonData = MyUtils.noDate();
      }
      return jsonData;
   }
}
