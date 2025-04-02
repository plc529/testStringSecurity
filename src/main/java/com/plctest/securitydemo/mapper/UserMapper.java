package com.plctest.securitydemo.mapper;

import com.plctest.securitydemo.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name} ")
    TUser select(String name);
}
