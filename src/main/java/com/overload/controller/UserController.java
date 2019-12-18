package com.overload.controller;

import com.overload.common.Const;
import com.overload.pojo.User;
import com.overload.service.IUserService;
import com.overload.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/portal/")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "user/login.do")
    public ServerResponse login(String username, String password, HttpSession session) {

        ServerResponse serverResponse = userService.loginLogic(username, password);
        if (serverResponse.isSucess()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;


    }

    @RequestMapping(value = "user/register.do")
    public ServerResponse register(String username, String password, String email, String phone, String question, String answer) {

        ServerResponse serverResponse = userService.registerLogic(username, password, email,  phone,  question,  answer);

        return serverResponse;

    }
}