package com.overload.common;

public enum ResponseCode {

     USERNAME_NOT_EMPTY(1,"用户名不能为空"),
     PASSWORD_NOT_EMPTY(2,"密码不能为空"),
    USERNAME_NOT_EXISTS(3,"用户名不存在"),
    PASSWORD_ERROR(4,"密码错误"),
    USERNAME_HAD_USED(1001,"用户名已被使用"),
    EMAIL_HAD_USED(1002,"邮箱已被使用"),
    EMAIL_NOT_EMPTY(1003,"邮箱不能为空"),
    PHONE_NOT_EMPTY(1004,"手机号不能为空"),
    QUESTION_NOT_EMPTY(1005,"密保问题不能为空"),
    ANSWER_NOT_EMPTY(1006,"密保答案不能为空"),
    REGISTER_ERROR(1007,"注册失败"),
//    ROLE_NOT_EMPTY(1008,"权限不能为空")



    ;


    private  int code;
    private String msg;

     ResponseCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
