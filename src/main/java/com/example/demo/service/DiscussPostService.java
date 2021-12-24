package com.example.demo.service;

import com.example.demo.dao.DiscussPostMapper;
import com.example.demo.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/3
 * Time: 10:47
 * Description: No Description
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
