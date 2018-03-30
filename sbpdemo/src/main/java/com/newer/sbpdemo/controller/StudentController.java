package com.newer.sbpdemo.controller;

import com.newer.sbpdemo.bean.Student;
import com.newer.sbpdemo.mapper.StudentMapper;
import com.newer.sbpdemo.service.StudentServite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//支持跨域请求，协议不同，地址不同，端口不同
@CrossOrigin(origins = "http://127.0.0.1:8080",maxAge = 3600)
@RequestMapping("/api")
@EnableCaching

public class StudentController {
    @Autowired
    private StudentServite studentServite;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ResponseEntity<?> getStudents(){
        List<Student> list=studentServite.findAll();
        return  new ResponseEntity<List<Student>>(list, HttpStatus.OK) ;
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ResponseEntity<?> getStu(@RequestParam("stuid")int stuid,
                                    @RequestParam("pwd")String pwd,
                                    HttpSession session){
        Student stu=studentServite.findById(stuid,pwd);
        if(stu==null){
            return new ResponseEntity<CustomerErrorType>(new CustomerErrorType("学号或密码错误"),HttpStatus.OK);
        }else {
            session.setAttribute("loginer",stu);
            return new ResponseEntity<Student>(stu,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/usersession",method = RequestMethod.GET)
    public ResponseEntity<?> usersession(HttpSession session){
        Student stu=(Student)session.getAttribute("loginer");
        return new ResponseEntity<Student>(stu,HttpStatus.OK);
    }


}