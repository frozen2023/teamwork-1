package com.chen.email.service.impl;

import com.chen.email.util.JavaEmailUtil;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
public class SendEmailServiceImpl implements com.chen.email.service.SendEmailService{
    public Map<String,Object> sendEmail(String toEmail,String msg) throws Exception
    {
        Map<String,Object> map=new HashMap<>();
        //	创建Session会话
        Session session = JavaEmailUtil
                .createSession();
//	创建邮件对象
        MimeMessage message = new MimeMessage(session);
        message.setSubject("成绩单");
        message.setText(msg);
        message.setFrom(new InternetAddress("430478184@qq.com"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
//	发送
        try
        {
            Transport.send(message);
            map.put("msg","发送成功");

        } catch ( Exception e) {
            map.put("msg","发送失败");
        }
        return map;
    }
}
