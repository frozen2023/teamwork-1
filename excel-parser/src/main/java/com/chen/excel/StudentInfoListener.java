package com.chen.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import com.alibaba.excel.event.Listener;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Frozen
 * */
@Slf4j
public class StudentInfoListener implements ReadListener<StudentCourseModel> {

    private List<StudentCourseModel> results = new ArrayList<>();

    @Override
    public void invoke(StudentCourseModel studentCourseModel, AnalysisContext analysisContext) {
        log.info("选课时间：{}， 学号：{}，姓名：{}，课程名称：{}，学分：{}，百分成绩：{}，五分成绩：{}，考试类型；{}，选修类型：{}", studentCourseModel.getTime(),
                studentCourseModel.getStudentNumber(),
                studentCourseModel.getName(),
                studentCourseModel.getCourse(),
                studentCourseModel.getCredit(),
                studentCourseModel.getGradeHundred(),
                studentCourseModel.getGradeFive(),
                studentCourseModel.getExamineType(),
                studentCourseModel.getElectiveType());
        this.results.add(studentCourseModel);
    }

    public List<StudentCourseModel> getResults() {
        return results;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("读取完毕！");
    }
}
