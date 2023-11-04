package com.chen.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentCourseModel {
    @ExcelProperty(value = "选课时间")
    private String time;
    @ExcelProperty(value = "学号")
    private String studentNumber;
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "课程名称")
    private String course;
    @ExcelProperty(value = "学分")
    private String credit;
    @ExcelProperty(value = "百分成绩")
    private String gradeHundred;
    @ExcelProperty(value = "五分成绩")
    private String gradeFive;
    @ExcelProperty(value = "考试类型")
    private String examineType;
    @ExcelProperty(value = "选修类型")
    private String electiveType;
}
