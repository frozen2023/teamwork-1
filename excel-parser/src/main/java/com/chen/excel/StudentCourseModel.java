package com.chen.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentCourseModel {
    @ExcelProperty(value = {"成绩查询","选课时间"})
    private String time;
    @ExcelProperty(value = {"成绩查询","学号"})
    private String studentNumber;
    @ExcelProperty(value = {"成绩查询","姓名"})
    private String name;
    @ExcelProperty(value = {"成绩查询","课程名称"})
    private String course;
    @ExcelProperty(value = {"成绩查询","学分"})
    private String credit;
    @ExcelProperty(value = {"成绩查询","百分成绩"})
    private String gradeHundred;
    @ExcelProperty(value = {"成绩查询","五分成绩"})
    private String gradeFive;
    @ExcelProperty(value = {"成绩查询","考试类型"})
    private String examineType;
    @ExcelProperty(value = {"成绩查询","选修类型"})
    private String electiveType;
}
