package com.dykj.webApi.convert.system;

import com.dykj.webApi.dto.system.JcUserDto;
import com.dykj.webApi.pojo.system.JcUser;
import org.springframework.beans.BeanUtils;

/**
 * @author:ctj
 * @date:2023/8/28
 * @Description: 用户表转化类
 */
public class JcUserConvert {
    /**
     * dto转pojo
     * @param jcUserDto
     * @return
     */
    public static JcUser dtoToPojo(JcUserDto jcUserDto){
        JcUser jcUser = new JcUser();
        BeanUtils.copyProperties(jcUserDto,jcUser);
        return jcUser;
    }
}
