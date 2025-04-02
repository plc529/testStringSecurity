package com.plctest.securitydemo.util;

import com.plctest.securitydemo.entity.TUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoginInfoUtil {

    //定义获取当前登录用户信息的方法反回
    public static TUser getCurrentLoginUserInfo(){
        return (TUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
