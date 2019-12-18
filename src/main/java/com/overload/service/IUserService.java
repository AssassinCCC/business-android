package com.overload.service;


import com.overload.utils.ServerResponse;

public interface IUserService {

    /**
     * 登录
     * */
    public ServerResponse loginLogic(String username, String password);

    public ServerResponse registerLogic(String username, String password ,String email,String phone,String question,String answer);



}
