package com.dykj.webApi.security.service.impl;

import com.dykj.webApi.dao.system.JcUserMapper;
import com.dykj.webApi.dao.system.JcUserMapperCustom;
import com.dykj.webApi.pojo.system.JcUser;

import com.dykj.webApi.security.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author:ctj
 * @date:2023/8/29
 * @Description:
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private JcUserMapper jcUserMapper;
    @Resource
    private JcUserMapperCustom jcUserMapperCustom;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        JcUser jcUser = this.jcUserMapperCustom.findOneByUsername(username);
        if (ObjectUtils.isEmpty(jcUser)){
            throw new RuntimeException("用户名或密码错误!");
        }

        //TODO 权限信息
        return new LoginUser(jcUser);
    }
}
