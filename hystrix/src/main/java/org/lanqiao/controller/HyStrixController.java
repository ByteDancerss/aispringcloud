package org.lanqiao.controller;

import org.lanqiao.bean.Student;
import org.lanqiao.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HyStrixController {
    @Autowired
    private StudentDao dao;

    @RequestMapping("/getStudentAll")
    public Collection<Student> getStudentAll(){
        return dao.getStudentAll();
    }

    @RequestMapping("/index")
    public String index(){
        return dao.index();
    }

}
