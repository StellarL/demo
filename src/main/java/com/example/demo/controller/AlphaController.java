package com.example.demo.controller;

import com.example.demo.service.AlphaService;
import com.example.demo.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/11/29
 * Time: 17:46
 * Description: No Description
 */

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/daoType")
    @ResponseBody
    public String getDate(){
        return alphaService.find();
    }


    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
//        获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration=request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try(
                PrintWriter writer=response.getWriter();
                ) {
            writer.write("<h1>标题1</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @Description:GET请求
     *     /students?current=1&limit=20
     * @Author: LiXin
     * @Date: 2021/11/30 11:06
     * @Param [current, limit]
     * @Return java.lang.String
     **/
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                              @RequestParam(name = "limit",defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }


    /**
     * @Description:/student/123参数成为路径一部分
     * @Author: LiXin
     * @Date: 2021/11/30 11:09
     * @Param [id]
     * @Return java.lang.String
     **/
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    /**
     * @Description://    Post请求
     * @Author: LiXin
     * @Date: 2021/11/30 11:21
     * @Param [name, age]
     * @Return java.lang.String
     **/
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    /**
     * @Description:响应HTML数据
     * @Author: LiXin
     * @Date: 2021/11/30 11:24
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    /**
     * @Description:与上面一样，返回的是路径
     * @Author: LiXin
     * @Date: 2021/11/30 11:29
     * @Param [model]
     * @Return java.lang.String 路径。为模板存放的地方
     **/
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age","100");
        return "/demo/view";
    }


    /**
     * @Description:响应json数据 异步请求（不刷新页面就有及时的访问数据库结果）
     *     返回java对象 --> json --> js对象
     * @Author: LiXin
     * @Date: 2021/11/30 14:54
     * @Param []
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> map= new HashMap<>();
        map.put("name","张三");
        map.put("age",32);
        map.put("salary",34343);
        return map;
    }


    /**
     * @Description: 返回json
     * @Author: LiXin
     * @Date: 2021/11/30 14:55
     **/
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map= new HashMap<>();
        map.put("name","张三");
        map.put("age",32);
        map.put("salary",34343);
        list.add(map);
        map= new HashMap<>();
        map.put("name","李四");
        map.put("age",3);
        map.put("salary",555);
        list.add(map);
        map= new HashMap<>();
        map.put("name","王五");
        map.put("age",12);
        map.put("salary",333);
        list.add(map);
        return list;
    }


    /**
     * @Description: cookie示例
     * @Author: LiXin
     * @Date: 2021/12/9 16:40
     **/
    @RequestMapping(path = "/cookie/set",method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response){
        //创建cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        //设置cookie生效范围
        cookie.setPath("/community");
        //设置cookie存放时间（默认关掉就没有了
        cookie.setMaxAge(60*10);
        //发送cookie
        response.addCookie(cookie);
        return "set Cookie";
    }


    /**
     * @Description: cookie在请求里，取cookie
     * @Author: LiXin
     * @Date: 2021/12/9 16:40
     **/
    @RequestMapping(path = "/cookie/get",method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code){
        System.out.println(code);
        return "get Cookie";
    }

    /**
     * @Description: session示例
     * @Author: LiXin
     * @Date: 2021/12/9 16:40
     **/
    @RequestMapping(path = "/session/set",method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session){
        session.setAttribute("id",1);
        session.setAttribute("name","Text");
        return "setSession";
    }

    @RequestMapping(path = "/session/get",method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session){
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "getSession";
    }
}
