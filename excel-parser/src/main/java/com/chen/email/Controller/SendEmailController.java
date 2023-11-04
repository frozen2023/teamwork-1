package com.chen.email.Controller;

import com.chen.email.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/email")
public class SendEmailController {
    @Autowired
    SendEmailService sendEmailService;
    @RequestMapping("/send")
    public Map<String,Object> sendEmail(String toEmail, String msg) throws Exception
    {
        return sendEmailService.sendEmail(toEmail,msg);
    }

}
