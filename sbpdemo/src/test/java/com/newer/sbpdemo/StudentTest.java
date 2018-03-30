package com.newer.sbpdemo;

import com.newer.sbpdemo.bean.Student;

import com.newer.sbpdemo.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test(){
        List<Student> list=studentMapper.findAll();
        System.out.println(list.size());
    }

}
