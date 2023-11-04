package com.chen.excel;

import com.alibaba.excel.EasyExcel;
import com.chen.email.EmailUtil;
import javafx.util.Pair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* @author Frozen
* */
public class ExcelParser {

    private InputStream inputStream;

    public ExcelParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        StudentInfoListener listener = new StudentInfoListener();
        // 解析excel
        EasyExcel.read(inputStream, StudentCourseModel.class, listener)
                .sheet()
                .doRead();
        // 解析结果
        List<StudentCourseModel> results = listener.getResults();
        Map<String, List<GradePair>> grades = new HashMap<>();
        for (StudentCourseModel each : results) {
            String name = each.getName();
            List<GradePair> list;
            if (!grades.containsKey(name)) {
                list = new ArrayList<>();
            } else {
                list = grades.get(name);
            }
            list.add(new GradePair(each.getCourse(), each.getGradeHundred()));
            grades.put(name, list);
        }
        // 发送短信
        for (String each : grades.keySet()) {
            StringBuilder builder = new StringBuilder();
            builder.append("亲爱的").append(each).append("同学:\n祝贺您顺利完成本学期的学习！教务处在此向您发送最新的成绩单。\n\n");
            List<GradePair> pairs = grades.get(each);
            int cnt = 0;
            for (GradePair pair : pairs) {
                if (cnt++ == 2) {
                    builder.append("\n");
                    cnt = 0;
                }
                builder.append(pair.getCourse()).append(": ").append(pair.getGrade()).append(" ");
            }
            builder.append("\n希望您能够对自己的成绩感到满意，并继续保持努力和积极的学习态度。如果您在某些科目上没有达到预期的成绩，不要灰心，这也是学习过程中的一部分。我们鼓励您与您的任课教师或辅导员进行交流，他们将很乐意为您解答任何疑问并提供帮助。请记住，学习是一个持续不断的过程，我们相信您有能力克服困难并取得更大的进步。\n\n再次恭喜您，祝您学习进步、事业成功！\n\n教务处");
            String message = builder.toString();
            try {
                EmailUtil.sendEmail("2095637923@qq.com", message);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static class GradePair {
        private String course;

        private String grade;

        public GradePair(String course, String grade) {
            this.course = course;
            this.grade = grade;
        }

        public String getCourse() {
            return course;
        }

        public String getGrade() {
            return grade;
        }
    }

}
