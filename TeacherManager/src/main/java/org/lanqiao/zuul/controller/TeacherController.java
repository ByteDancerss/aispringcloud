package org.lanqiao.zuul.controller;

import com.netflix.discovery.converters.Auto;
import org.lanqiao.zuul.bean.Student;
import org.lanqiao.zuul.bean.Teacher;
import org.lanqiao.zuul.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherDao dao;
    @Auto
    private RestTemplate restTemplate;

    private static String baseUrl = "http://localhost:8762/student";

    @GetMapping("/getTeacherById/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id){
        return dao.getTeacherById(id);
    }

    @GetMapping("/getTeacherAll")
    public Collection<Teacher> getTeacherAll(){
        return dao.getTeacherAll();
    }

    @GetMapping("/getTeacher")
    public Collection<Student> getTeacher(){
        return dao.getTeacher();
    }

    //获取所有学生,使用getForEnity()方法,需要在后面+getBody() 来获取其内容
    @GetMapping("/getStudentAll")
    public Collection<Student> getStudentAll(){
        return dao.getTeacher();
    }

    //获取所有学生方法，使用getForObject()方法,指定什么类型就返回什么其类型，无需getBody()
//    @GetMapping("/getStudentAlls")
//    public Collection<Student> getStudentAlls(){
//        return restTemplate.getForObject(baseUrl+"/getStudentAll",Collection.class);
//    }

    //获取单个学生,使用getForEntity()方法
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return dao.getStudentById(id);
    }

    //获取单个学生,使用getForObject()方法
    @GetMapping("/getStudentByIds/{id}")
    public Student getStudentByIds(@PathVariable("id") Long id){
       return dao.getStudentByIds(id);
    }

    //添加学生
    @PutMapping("/addStudent")
    public Collection<Student> addStudent(@RequestBody Student info){
        return dao.addStudent(info);
    }

    //修改学生,使用postForEntity()方法，第一个参数未url,第二个为参数,第三个为类型
    @PostMapping("/updateStudent")
    public Collection<Student> updateStudent(@RequestBody Student info){
        return dao.updateStudent(info);
    }

    //修改学生使用postForObject()方法
    @PostMapping("/updateStudent2")
     public Collection<Student> updateStudent2(@RequestBody Student info){
        return dao.updateStudent2(info);
    }


}
