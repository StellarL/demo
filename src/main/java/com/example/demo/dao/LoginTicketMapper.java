package com.example.demo.dao;

import com.example.demo.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/14
 * Time: 11:26
 * Description: No Description
 */

@Mapper
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket{user_id,ticket,status,expired} ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\">",
            "</if>",
            "</script>"

    })
    int updateStatus(String ticket,int status);

}
