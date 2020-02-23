package org.lanqiao.zuul.dao;

import org.lanqiao.zuul.bean.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getStudentAll();
    Student getStudentById(Long id);
    Collection<Student> delStudentById(Long id);
    Collection<Student> updateOrAddStudent(Student info);
}
