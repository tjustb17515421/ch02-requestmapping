package com.mou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping:
 *  位置：放在类上面
 *  value:所有请求地址的公共部分，叫做模块名称
 */
@RequestMapping("/uesr")
@Controller
public class MyController {

    /**
     * @RequestMapping的属性:
     *      method: 表示请求的方式，它的值是枚举型
     *              1.get:   RequestMethod.GET
     *              2.post:  RequestMethod.POST
     */
    //指定some.do使用get请求方式
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView dosome(){

        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc开发");
        mv.addObject("fun","执行的是dosome方法");
        mv.setViewName("show");//设置视图是show.jsp,这里利用视图解析器已经省略路径名
        return mv;//返回 这个视图（视图中包括其中的信息）
    }
    //指定other.do使用post请求方式
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doother(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc开发");
        mv.addObject("fun","执行的是doother方法");
        mv.setViewName("other");
        return mv;
    }
    //不指定任何请求方式，就没有限制
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request,
                                HttpServletResponse response,
                                HttpSession session){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc开发"+request.getParameter("name"));
        mv.addObject("fun","执行的是dofirst方法");
        mv.setViewName("other");
        return mv;
    }
}
