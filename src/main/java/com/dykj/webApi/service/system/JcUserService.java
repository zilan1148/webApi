package com.dykj.webApi.service.system;

import com.dykj.webApi.pojo.system.JcUser;

/**
 * @author:ctj
 * @date:2023/8/28
 * @Description: 用户相关操作
 */
public interface JcUserService {
    /**
     * 添加新的用户
     * @param jcUser
     * @return
     */
    int saveUser(JcUser jcUser);

}
