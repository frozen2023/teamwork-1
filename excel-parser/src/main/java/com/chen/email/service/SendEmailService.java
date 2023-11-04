package com.chen.email.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface SendEmailService {
    Map<String,Object> sendEmail(String toEmail,String msg) throws Exception;
}
