package com.chen.excel;

import com.alibaba.excel.EasyExcel;

import java.io.InputStream;

public class ExcelParser {

    private InputStream inputStream;

    public ExcelParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        EasyExcel.read(inputStream, StudentCourseModel.class, new StudentInfoListener())
                .sheet()
                .doRead();
    }

}
