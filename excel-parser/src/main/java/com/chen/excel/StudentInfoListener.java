package com.chen.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;

import java.io.Reader;

@Slf4j
public class StudentInfoListener implements ReadListener<StudentCourseModel> {
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
         // TODO:发送邮件通知
        String.format("亲爱的[学生姓名]同学:\n" +
                "\n" +
                "祝贺您顺利完成本学期的学习！教务处在此向您发送最新的成绩单。\n" +
                "\n" +
                "[科目1]： [成绩1] [科目2]： [成绩2] [科目3]： [成绩3]\n" +
                "\n" +
                "……\n" +
                "\n" +
                "希望您能够对自己的成绩感到满意，并继续保持努力和积极的学习态度。如果您在某些科目上没有达到预期的成绩，不要灰心，这也是学习过程中的一部分。我们鼓励您与您的任课教师或辅导员进行交流，他们将很乐意为您解答任何疑问并提供帮助。请记住，学习是一个持续不断的过程，我们相信您有能力克服困难并取得更大的进步。\n" +
                "\n" +
                "再次恭喜您，祝您学习进步、事业成功！\n" +
                "\n" +
                "教务处");


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("读取完毕！");
    }
}
