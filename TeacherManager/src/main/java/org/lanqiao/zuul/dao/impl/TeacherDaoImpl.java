package org.lanqiao.zuul.dao.impl;

import org.lanqiao.zuul.bean.Student;
import org.lanqiao.zuul.bean.Teacher;
import org.lanqiao.zuul.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private RestTemplate restTemplate;
    private static Map<Long,Teacher> TeacherMap;
    private static String baseUrl = "http://localhost:8762/student";
    static {
        TeacherMap = new HashMap<>();
        TeacherMap.put(1L,new Teacher(1L,"张老师","123456"));
        TeacherMap.put(2L,new Teacher(2L,"袁老师","admin"));
        TeacherMap.put(3L,new Teacher(3L,"吴小宝","ak47123"));
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return TeacherMap.get(id);
    }

    @Override
    public Collection<Teacher> getTeacherAll() {
        return TeacherMap.values();
    }

    //获取学生端的信息
    @Override
    public Collection<Student> getTeacher() {
        return restTemplate.getForEntity("http://StudentManager/student/getStudentAll",Collection.class).getBody();
    }

    //获取单个学生,使用getForEntity()方法
    public Student getStudentById(Long id){
        return restTemplate.getForEntity(baseUrl+"/getStudentById/{id}",Student.class,id).getBody();
    }

    //获取单个学生,使用getForObject()方法
    public Student getStudentByIds(Long id){
        return restTemplate.getForObject(baseUrl+"/getStudentById/{id}",Student.class,id);
    }

    //添加学生
    public Collection<Student> addStudent(Student info){
        restTemplate.put(baseUrl+"/addStudent",info);       //进行添加操作
        return restTemplate.getForObject(baseUrl+"/getStudentAll",Collection.class);
    }

    //修改学生,使用postForEntity()方法，第一个参数未url,第二个为参数,第三个为类型
    public Collection<Student> updateStudent(Student info){
        return restTemplate.postForEntity(baseUrl+"/updateStudent",info,Collection.class).getBody();
    }

    //修改学生使用postForObject()方法
    public Collection<Student> updateStudent2(Student info){
        return restTemplate.postForObject(baseUrl+"/updateStudent",info,Collection.class);
    }



}
