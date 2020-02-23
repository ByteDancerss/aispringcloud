package org.lanqiao.dao;

import org.lanqiao.bean.Student;
import org.lanqiao.dao.impl.FeginError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Repository         //表明自己是dao
@FeignClient(value = "StudentManager",fallback = FeginError.class)
public interface StudentDao {

    @GetMapping("/student/getStudentAll")
    Collection<Student> getStudentAll();

    @GetMapping("/student/index")
    String index();

}
