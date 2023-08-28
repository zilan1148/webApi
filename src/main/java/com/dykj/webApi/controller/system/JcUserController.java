package com.dykj.webApi.controller.system;

import com.dykj.webApi.bean.Result;
import com.dykj.webApi.constant.BaseConstant;
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
     * @return
     */
    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody JcUserDto jcUserDto){
        JcUser jcUser = JcUserConvert.dtoToPojo(jcUserDto);
        int code = this.jcUserService.saveUser(jcUser);

        if (BaseConstant.PARAM_NULL.equals(code)){
            return Result.error(ResultEnum.PARAM_IS_NULL);
        }
        return code == 0 ? Result.error(ResultEnum.INTERFACE_ERROR) :
                Result.success(ResultEnum.ADD_SUCCESS,code);
    }
}
