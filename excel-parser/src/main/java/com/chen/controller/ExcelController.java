package com.chen.controller;

import com.chen.common.CommonResult;
import com.chen.service.ExcelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class ExcelController {

    @Resource
    private ExcelService excelService;

    @PostMapping("/excel/parse")
    public CommonResult parseExcel(@RequestPart("excel") MultipartFile excelFile) {
        System.out.println(excelFile != null);
        return excelService.parseExcel(excelFile);
    }
}
