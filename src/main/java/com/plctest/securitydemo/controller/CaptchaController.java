package com.plctest.securitydemo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;

import com.mysql.jdbc.Driver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

//@Controller
public class CaptchaController {
    @RequestMapping(value = "/cpmmon/captcha")
    public void generateCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成验证码工具
        ICaptcha captcha = CaptchaUtil.createCircleCaptcha(90,30,4,10,1);
        //保存数字在后端
        request.getSession().setAttribute("captcha",captcha.getCode());
        //把验证码输出到web
        captcha.write(response.getOutputStream());
    }


}
