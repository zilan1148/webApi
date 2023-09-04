package com.dykj.webApi.dao.system;
import org.apache.ibatis.annotations.Param;

import com.dykj.webApi.pojo.system.JcUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author DELL
 * @date 2023年8月28日15:17:01
 */
@Mapper
public interface JcUserMapperCustom {

    JcUser findOneByUsername(@Param("username")String username);


}