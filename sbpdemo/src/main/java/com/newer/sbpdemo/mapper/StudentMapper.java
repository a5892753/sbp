package com.newer.sbpdemo.mapper;

import com.newer.sbpdemo.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select stuid,stuname,stusex from student")
    List<Student> findAll();


    @Select("select stuid,stuname,stusex from " +
            "student where stuid=#{stuid} and pwd=#{pwd}")
    Student findById(@Param("stuid")int stuid, @Param("pwd") String pwd);

    @Update("update set pwd=#{password} where stuid=#{stuid}")

}
