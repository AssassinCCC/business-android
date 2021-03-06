package com.overload.dao;

import com.overload.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(User record);

    Integer findByUsername(String username);


    Integer findByEmail(String email);

    /**
     * 根据用户名和密码查询
     * */
    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    /**
     * 注册
     * */
//    boolean insertUser(@Param("username") String username,@Param("password") String password,@Param("email") String email,@Param("phone") String phone,@Param("question") String question,@Param("answer") String answer);
}