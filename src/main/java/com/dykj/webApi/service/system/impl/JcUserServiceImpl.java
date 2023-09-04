package com.dykj.webApi.service.system.impl;

import com.dykj.webApi.constant.BaseConstant;
import com.dykj.webApi.constant.system.JcUserConstant;
import com.dykj.webApi.dao.system.JcUserMapper;
import com.dykj.webApi.dao.system.JcUserMapperCustom;
import com.dykj.webApi.pojo.system.JcUser;
import com.dykj.webApi.security.utils.PasswordEncoderUtils;
import com.dykj.webApi.service.system.JcUserService;
import com.dykj.webApi.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author:ctj
 * @date:2023/8/28
 * @Description: 用户相关操作实现类
 */
@Service
public class JcUserServiceImpl implements JcUserService {

    @Resource
    private JcUserMapper jcUserMapper;
    @Resource
    private JcUserMapperCustom jcUserMapperCustom;

    /**
     * 添加新的用户
     * @param jcUser
     * @return
     */
    @Override
    public int saveUser(JcUser jcUser) {
        if (ObjectUtils.isEmpty(jcUser)){
            return BaseConstant.PARAM_NULL;
        }
        //设置主键
        jcUser.setUserId(UUIDUtil.getUUID());
        //设置创建时间
        jcUser.setRegisterTime(new Date());
        //设置创建IP地址
        try {
            jcUser.setRegisterIp(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //判断是否存在重复的用户名
        JcUser oneByUsername = this.jcUserMapperCustom.findOneByUsername(jcUser.getUsername());
        if (!ObjectUtils.isEmpty(oneByUsername)){
            return JcUserConstant.USERNAME_REPEAT;
        }
        //密码加密
        String encodePassword = PasswordEncoderUtils.encodePassword(jcUser.getPassword());
        jcUser.setPassword(encodePassword);
        int code = this.jcUserMapper.insertSelective(jcUser);
        return code;
    }

    /**
     * 根据用户ID查询用户
     * @param userId
     * @return
     */
    @Override
    public JcUser findOneByUserId(String userId) {
        if(StringUtils.isBlank(userId)){
            return null;
        }
        JcUser jcUser = this.jcUserMapper.selectByPrimaryKey(userId);
        return jcUser;
    }

    /**
     * 根据ID获取用户
     * @param username
     * @return JcUser
     */
    @Override
    public JcUser findOneByUsername(String username) {
        if(StringUtils.isBlank(username)){
            return null;
        }
        JcUser jcUser = this.jcUserMapperCustom.findOneByUsername(username);
        return jcUser;
    }
}
