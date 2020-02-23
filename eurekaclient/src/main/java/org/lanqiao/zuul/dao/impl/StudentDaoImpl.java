package org.lanqiao.zuul.dao.impl;

import org.lanqiao.zuul.bean.Student;
import org.lanqiao.zuul.dao.StudentDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {
    private static Map<Long, Student> StudentMap;

    static {
        StudentMap = new HashMap<>();
        StudentMap.put(1L,new Student(1L,"张三",22));
        StudentMap.put(2L,new Student(2L,"李四",23));
        StudentMap.put(3L,new Student(3L,"王五",24));
        StudentMap.put(4L,new Student(4L,"李嘉欣",25));
    }

    @Override
    public Collection<Student> getStudentAll() {
        return StudentMap.values();
    }

    @Override
    public Student getStudentById(Long id) {
        return StudentMap.get(id);
    }

    @Override
    public Collection<Student> delStudentById(Long id) {
        StudentMap.remove(id);
        return StudentMap.values();
    }

    @Override
    public Collection<Student> updateOrAddStudent(Student info) {
        StudentMap.put(info.getId(),info);
        return StudentMap.values();
    }

}
