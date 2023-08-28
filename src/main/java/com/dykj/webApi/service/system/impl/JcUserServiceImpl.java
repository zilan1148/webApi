package com.dykj.webApi.service.system.impl;

import com.dykj.webApi.constant.BaseConstant;
import com.dykj.webApi.dao.system.JcUserMapper;
import com.dykj.webApi.pojo.system.JcUser;
import com.dykj.webApi.service.system.JcUserService;
import com.dykj.webApi.utils.UUIDUtil;
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
        int code = this.jcUserMapper.insertSelective(jcUser);
        return code;
    }
}
