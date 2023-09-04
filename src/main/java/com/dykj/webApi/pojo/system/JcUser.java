package com.dykj.webApi.pojo.system;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 * @author DELL
 * @date 2023年8月28日15:17:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JcUser implements Serializable {
    /**
    * 主键ID
    */
    private String userId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 真实姓名
    */
    private String realName;

    /**
    * 用户性别 1男 0女 2保密
    */
    private Integer userSex;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 创建时间
    */
    private Date registerTime;

    /**
    * 创建IP
    */
    private String registerIp;

    /**
    * 最后登录时间
    */
    private Date lastLoginTime;

    /**
    * 登录次数
    */
    private Integer loginCount;

    /**
    * 最后登录IP
    */
    private String lastLoginIp;

    /**
    * 登录失败时间
    */
    private Date errorTime;

    /**
    * 登录失败IP
    */
    private String errorIp;

    /**
    * 登录失败次数
    */
    private Integer errorCount;

    /**
    * 用户级别
    */
    private Integer rank;

    /**
    * 用户状态 1启用 0禁用
    */
    private Boolean status;

    /**
    * 是否为受限用户 1是 0不是(受限用户只能管理自己的数据)
    */
    private Boolean isLimited;

    /**
    * 假删除标记 1数据有效 0数据无效
    */
    private Boolean flagDel;

    private static final long serialVersionUID = 1L;
}