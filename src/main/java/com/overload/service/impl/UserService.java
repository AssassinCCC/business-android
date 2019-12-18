package com.overload.service.impl;


import com.overload.common.Const;
import com.overload.common.ResponseCode;
import com.overload.dao.UserMapper;
import com.overload.pojo.User;
import com.overload.service.IUserService;
import com.overload.utils.DateUtil;
import com.overload.utils.MD5Utils;
import com.overload.utils.ServerResponse;
import com.overload.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse loginLogic(String username, String password) {

        //step1: 用户名和密码的非空判断
         if(username==null||username.equals("")){
             //
             return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
         }
        if(password==null||password.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        //step2:查看用户名是否存在
        Integer count= userMapper.findByUsername(username);
        if(count==0){
            //用户名不存在
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EXISTS.getCode(),ResponseCode.USERNAME_NOT_EXISTS.getMsg());
        }

        //step3: 根据用户名和密码查询
//          User user=userMapper.findByUsernameAndPassword(username, password);
        User user=userMapper.findByUsernameAndPassword(username, MD5Utils.getMD5Code(password));
        System.out.println(MD5Utils.getMD5Code(password));
        if(user==null){
          return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_ERROR.getCode(),ResponseCode.PASSWORD_ERROR.getMsg());
        }
        //step4:返回结果


        return ServerResponse.createServerResponseBySucess(convert(user));
    }

    @Override
    public ServerResponse registerLogic(String username, String password, String email, String phone, String question, String answer) {
        //step1: 用户名和密码的非空判断
        if(username==null||username.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_NOT_EMPTY.getCode(),ResponseCode.USERNAME_NOT_EMPTY.getMsg());
        }

        //step2:查看用户名是否存在
        Integer count= userMapper.findByUsername(username);
        if(count>0){
            //用户名已存在
            return ServerResponse.createServerResponseByFail(ResponseCode.USERNAME_HAD_USED.getCode(),ResponseCode.USERNAME_HAD_USED.getMsg());
        }

        if(password==null||password.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.PASSWORD_NOT_EMPTY.getCode(),ResponseCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        if(email==null||email.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.EMAIL_NOT_EMPTY.getCode(),ResponseCode.EMAIL_NOT_EMPTY.getMsg());
        }

        //step2:查看邮箱是否存在
        count= userMapper.findByEmail(email);
        if(count>0){
            //邮箱已存在
            return ServerResponse.createServerResponseByFail(ResponseCode.EMAIL_HAD_USED.getCode(),ResponseCode.EMAIL_HAD_USED.getMsg());
        }

        if(phone==null||phone.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.PHONE_NOT_EMPTY.getCode(),ResponseCode.PHONE_NOT_EMPTY.getMsg());
        }
        if(question==null||question.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.QUESTION_NOT_EMPTY.getCode(),ResponseCode.QUESTION_NOT_EMPTY.getMsg());
        }
        if(answer==null||answer.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.ANSWER_NOT_EMPTY.getCode(),ResponseCode.ANSWER_NOT_EMPTY.getMsg());
        }
        /*if(role==null||answer.equals("")){
            //
            return ServerResponse.createServerResponseByFail(ResponseCode.ROLE_NOT_EMPTY.getCode(),ResponseCode.ROLE_NOT_EMPTY.getMsg());
        }*/
        User user = new User();
        user.setAnswer(answer);
        user.setCreateTime(new Date());
        user.setQuestion(question);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setPassword(MD5Utils.getMD5Code(user.getPassword()));
        user.setUsername(username);
        user.setRole(Const.NORMAL_USER);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIp("2");
        user.setUserpic("2.jpg");

        if(userMapper.insert(user)>0){
            return ServerResponse.createServerResponseBySucess(user);
        }else {
            return ServerResponse.createServerResponseByFail(ResponseCode.REGISTER_ERROR.getCode(),ResponseCode.REGISTER_ERROR.getMsg());
        }



    }


    private UserVO convert(User user){
        UserVO userVO=new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getUsername());
        userVO.setEmail(user.getEmail());
        userVO.setPhone(user.getPhone());
        userVO.setCreateTime(DateUtil.date2String(user.getCreateTime()));
        userVO.setUpdateTime(DateUtil.date2String(user.getUpdateTime()));

        return userVO;
    }

}
