package com.chen.email.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class JavaEmailUtil {
    private JavaEmailUtil() {}

    public static Session createSession() {

        //	账号信息
        String username = "430478184@qq.com";//	邮箱发送账号
        String password = "diqhtmwmgzwhbjga";//	邮箱授权码

        //	创建一个配置文件，并保存
        Properties props = new Properties();

        //	SMTP服务器连接信息
        //  126——smtp.126.com
        //  163——smtp.163.com
        //  qqsmtp.qq.com"
        props.put("mail.smtp.host", "smtp.qq.com");//	SMTP主机名
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        //  126——25
        //  163——645
        props.put("mail.smtp.port", "587");//	主机端口号
       props.put("mail.smtp.auth", "true");//	是否需要用户认证
        props.put("mail.smtp.starttls.enale", "true");//	启用TlS加密

        Session session = Session.getInstance(props,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(username,password);
            }
        });

        //  控制台打印调试信息
        session.setDebug(true);
        return session;

    }
}
