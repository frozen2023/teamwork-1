package com.chen.service;

import com.chen.common.CommonResult;
import com.chen.excel.ExcelParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ExcelService {

    public CommonResult parseExcel(MultipartFile exf) {
        ExcelParser parser;
        try {
            parser = new ExcelParser(exf.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error("解析失败！");
        }
        parser.parse();
        return CommonResult.success();
    }
}
