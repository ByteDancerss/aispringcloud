package org.lanqiao.dao;

import org.lanqiao.bean.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class StudentDaoImpl implements StudentDao{

    @Override
    public Collection<Student> getStudentAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器异常,稍后再试...";
    }
}
