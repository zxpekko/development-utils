package com.nnuclub.util;

//import com.jingdianjichi.subject.context.LoginContextHolder;

//import com.jingdianjichi.subject.common.context.LoginContextHolder;

import com.nnuclub.context.LoginContextHolder;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:41 2024/4/10
 */
public class LoginUtil {
    public static String getLoginId(){
        return LoginContextHolder.getLoginId();
    }
}
