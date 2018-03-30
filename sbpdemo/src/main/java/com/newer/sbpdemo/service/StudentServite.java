package com.newer.sbpdemo.service;

import com.newer.sbpdemo.bean.Student;
import com.newer.sbpdemo.mapper.StudentMapper;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class StudentServite {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAll(){
        return studentMapper.findAll();
    }


    public Student findById(int stuid,String pwd){
        return studentMapper.findById(stuid,pwd);
    }
}
