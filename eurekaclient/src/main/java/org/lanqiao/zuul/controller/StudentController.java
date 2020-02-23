package org.lanqiao.zuul.controller;

import org.lanqiao.zuul.bean.Student;
import org.lanqiao.zuul.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDao dao;

    @Value("${server.port}")        //获取yml文件中的端口号,负载均衡
    private  String port;

    @GetMapping("/getStudentAll")
    public Collection<Student> getStudentAll(){
        return dao.getStudentAll();
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return dao.getStudentById(id);
    }

    @DeleteMapping("/delStudentById/{id}")
    public Collection<Student> delStudentById(@PathVariable("id") Long id){
        return dao.delStudentById(id);
    }

    @PutMapping("/addStudent")
    public Collection<Student> addStudent(@RequestBody Student info){
        System.out.println(info);
        return dao.updateOrAddStudent(info);
    }

    @PostMapping("/updateStudent")
    public Collection<Student> updateStudent(@RequestBody Student info){
        return dao.updateOrAddStudent(info);
    }

    @RequestMapping("/index")
    public String hello(){
        return "当前服务端口号:"+this.port;
    }


}
