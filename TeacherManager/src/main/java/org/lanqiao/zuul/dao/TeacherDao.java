package org.lanqiao.zuul.dao;


import org.lanqiao.zuul.bean.Student;
import org.lanqiao.zuul.bean.Teacher;

import java.util.Collection;

public interface TeacherDao {
    Teacher getTeacherById(Long id);
    Collection<Teacher> getTeacherAll();
    Collection<Student> getTeacher();        //获取学生端信息
    Student getStudentById(Long id);
    Student getStudentByIds(Long id);
    Collection<Student> addStudent(Student info);
    Collection<Student> updateStudent(Student info);
    Collection<Student> updateStudent2(Student info);
}
