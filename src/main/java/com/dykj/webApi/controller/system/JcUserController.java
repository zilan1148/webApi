package com.dykj.webApi.controller.system;

import com.dykj.webApi.bean.Result;
import com.dykj.webApi.constant.BaseConstant;
import com.dykj.webApi.constant.system.JcUserConstant;
import com.dykj.webApi.convert.system.JcUserConvert;
import com.dykj.webApi.dto.system.JcUserDto;
import com.dykj.webApi.enums.ResultEnum;
import com.dykj.webApi.pojo.system.JcUser;
import com.dykj.webApi.service.system.JcUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:ctj
 * @date:2023/8/28
 * @Description:
 */
@RestController
@RequestMapping("/sys/jcUser")
public class JcUserController {

    @Resource
    private JcUserService jcUserService;

    /**
     * 添加新的用户
     * @param jcUserDto
     * @return Result
     */
    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody JcUserDto jcUserDto){
        //dto转pojo
        JcUser jcUser = JcUserConvert.dtoToPojo(jcUserDto);
        //保存用户
        int code = this.jcUserService.saveUser(jcUser);
        //判断状态码抛出不同结果
        if (BaseConstant.PARAM_NULL.equals(code)){
            return Result.error(ResultEnum.PARAM_IS_NULL);
        }
        if (JcUserConstant.USERNAME_REPEAT.equals(code)){
            return Result.error(ResultEnum.USERNAME_ALREADY_EXIST);
        }
        return code == 0 ? Result.error(ResultEnum.INTERFACE_ERROR) :
                Result.success(ResultEnum.ADD_SUCCESS,code);
    }
}
