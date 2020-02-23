package org.lanqiao.controller;

import org.lanqiao.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    //因为服务提供者已经注册，所有可以直接使用服务名代替端口号
    @RequestMapping("/getStudentAll")
    public Collection<Student> getStudentAll(){
        return restTemplate.getForObject("http://StudentManager/student/getStudentAll",Collection.class);
    }

    @RequestMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://StudentManager/student/index",String.class);
    }

}
