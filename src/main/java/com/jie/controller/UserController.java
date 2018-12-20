package com.jie.controller;

import com.jie.bean.Users;
import com.jie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author qiangzi
 * @create 2018--12--21 3:55
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService us;
    //跳转到登陆页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    //处理登陆业务
    @RequestMapping("/login")
    public @ResponseBody String login(Users u, HttpSession sess){
        Users u1=us.login(u);
        if(u1!=null){
            sess.setAttribute("user","u1");
            return "ok";
        }else{
            return "nook";
        }
    }
}
