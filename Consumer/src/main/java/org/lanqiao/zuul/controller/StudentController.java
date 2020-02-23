package org.lanqiao.zuul.controller;

import org.lanqiao.zuul.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class StudentController {
    @Autowired
    private RestTemplate restTemplate;

    private static String baseUrl = "http://localhost:8762/student";

    @RequestMapping("/getStudentAll")
    public Collection<Student> getStudentAll(){
        return restTemplate.getForEntity(baseUrl+"/getStudentAll",Collection.class).getBody();
    }

    @RequestMapping("/addStudent")
    public Collection<Student> addStudent(@RequestBody Student info){
        restTemplate.put(baseUrl+"/addStudent",info);
        return restTemplate.getForEntity(baseUrl+"/getStudentAll",Collection.class).getBody();
    }

    @RequestMapping("/updateStudent")
    public Collection<Student> updateStudent(@RequestBody Student info){
        return restTemplate.postForObject(baseUrl+"/updateStudent",info,Collection.class);
    }

    @RequestMapping("/delStudentById/{id}")
    public Object delStudentById(@PathVariable("id") Long id){
         restTemplate.delete(baseUrl+"/delStudentById/{id}",id);
         return restTemplate.getForEntity(baseUrl+"/getStudentAll",Collection.class).getBody();
    }

}
