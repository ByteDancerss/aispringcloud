package org.lanqiao.controller;

import org.lanqiao.bean.Student;
import org.lanqiao.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/fegin")
public class FeginController {
    @Autowired
    private StudentDao dao;

    //获取所有学生
    @RequestMapping("/getStudentAll")
    public Collection<Student> getStudentAll(){
        return dao.getStudentAll();
    }

    //获取服务的端口号，以此来判断feigin的负载均衡功能是否实现了
    @RequestMapping("/index")
    public String index(){
        return dao.index();
    }

}
