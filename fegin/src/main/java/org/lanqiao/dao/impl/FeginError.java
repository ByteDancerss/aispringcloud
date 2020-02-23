package org.lanqiao.dao.impl;

import org.lanqiao.bean.Student;
import org.lanqiao.dao.StudentDao;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeginError implements StudentDao {

    @Override
    public Collection<Student> getStudentAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器异常，请稍后再试...";
    }
}
