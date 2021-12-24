package com.example.demo;

import com.example.demo.dao.DiscussPostMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.DiscussPost;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/1
 * Time: 20:03
 * Description: No Description
 */

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertById() {
        User user = new User("ttt", "1", "1", "12@1", 1, 1, "sda", "http://www.nowcoder.com/101.png", new Date());
        System.out.println(userMapper.insertUser(user));
        System.out.println(user.getId());
    }

    @Test
    public void testupdate() {
        System.out.println(userMapper.updateStatus(150,0));
        System.out.println(userMapper.updatePassword(150,"dasdas"));
        System.out.println(userMapper.updateHeader(150,"http://www.nowcoder.com/102.png"));
    }

    @Test
    public void testDiscussPosts() {
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost discussPost:list){
            System.out.println(discussPost);
        }
        int n=discussPostMapper.selectDiscussPostRows(0);
        System.out.println(n);
    }

}
