package com.yuhaoze.service;

import com.yuhaoze.vo.PageVo;

public interface PicDownloadService {
    int add(int pid, int uid);
    PageVo getMyDownloadLog(int uid, int page, int limit);
    PageVo getMyDownloadLog1(int uid, int page, int limit);
}
