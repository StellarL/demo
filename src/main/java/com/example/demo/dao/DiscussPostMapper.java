package com.example.demo.dao;

import com.example.demo.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/3
 * Time: 10:21
 * Description: No Description
 */


@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset,int limit);

    //别名。对于动态参数<if>且只有一个的情况必须要加@Param
    int selectDiscussPostRows(@Param("userId") int userId);




}
