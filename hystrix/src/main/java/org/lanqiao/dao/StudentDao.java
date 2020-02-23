package org.lanqiao.dao;

import org.lanqiao.bean.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
@Repository
@FeignClient(value = "StudentManager",fallback = StudentDaoImpl.class)
public interface StudentDao {

    @GetMapping("/student/getStudentAll")
    Collection<Student> getStudentAll();

    @GetMapping("/student/index")
    String index();
}
