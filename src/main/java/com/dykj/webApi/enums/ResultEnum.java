package com.dykj.webApi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author: 张景川
 * Date: 2021/5/10 10:59
 * FileName: ResultEnum
 * Description: 返回状态值枚举
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    INTERFACE_ERROR(-1, "接口报错"),

    SUCCESS_PAY(200, "支付成功"),
    SUCCESS(200, "请求成功"),
    ADD_SUCCESS(200, "添加成功"),
    EDIT_SUCCESS(200, "编辑成功"),
    DELETE_SUCCESS(200, "删除成功"),
    IMPORT_SUCCESS(200, "导入成功"),
    REPLY_SUCCESS(200, "回复成功"),
    UPLOAD_SUCCESS(200, "上传成功"),
    RESULT_DATA_NULL(200, "无数据"),
    LOGOUT_SUCCESS(200, "登出！"),
    LOGIN_SUCCESS(200, "登录成功！"),

    PARAM_ERROR(300, "参数错误"),
    USERNAME_ALREADY_EXIST(301, "用户名已存在"),
    PHONE_ALREADY_EXIST(302, "手机号已存在"),
    EMAIL_ALREADY_EXIST(303, "邮箱已存在"),
    ROLE_NAME_ALREADY_EXIST(304, "角色名已存在"),
    PERMISSION_NAME_ALREADY_EXIST(305, "权限名已存在"),
    LOGIN_NAME_ISNULL(306, "登录名不可为空"),
    MAIL_PHONE_SENT(307, "邮箱或手机一定时间内已发送过信息"),
    INCORRECT_MAIL_FORMAT(308, "邮件格式不正确"),
    INCORRECT_PHONE_FORMAT(309, "手机号格式不正确"),
    SENT_ERROR(310, "发送失败"),
    OLD_PASSWORD_ERROR(311, "原密码不正确"),
    USER_OR_PASSWORD_IS_NULL(312, "用户名或密码不可为空"),
    USER_LOCKED(313, "用户被锁定"),
    LOGIN_NAME_OR_PASSWORD_ERROR(314, "登录名或密码错误"),
    USER_NO_HAVE_PERMISSION(315, "没有访问权限"),
    NAME_ALREADY_EXIST(316, "名称已存在"),
    MAIL_INVALID(317, "邮箱无效"),
    MAIL_OR_CODE_INVALID(318, "邮箱或验证码无效"),
    PASSWORD_ERROR(319, "密码错误"),
    VERIFICATION_CODE_ERROR(320, "验证码错误"),
    SYSTEM_CONFIG_NOT_EXIST(321, "配置参数不存在"),
    USER_LOGIN_OUT(322, "用户未登录"),
    USER_KICKED_OUT(323, "该账号已在另一设备登录"),
    TIME_OUT(333, "登录超时"),
    JWT_EXPIRE(341, "jwt过期，登录超时！"),
    REDIS_EXPIRE_LOGOUT(342, "Redis过期或已经登出，请登录！"),
    PARAM_IS_NULL(343,"请求参数为空！"),

    BODY_NOT_MATCH(400, "空指针!"),
    NOT_EXIST(401, "数据不存在"),
    DATA_EXIST(402, "数据已存在"),
    USER_NOT_EXIST(410, "用户不存在"),
    ROLE_NOT_EXIST(411, "角色不存在"),
    PERMISSION_NOT_EXIST(412, "权限不存在"),
    PERMISSION_PARENT_NOT_EXIST(414, "上级权限不存在"),
    DEPT_PARENT_NOT_EXIST(416, "上级部门不存在"),
    DEPT_NOT_EXIST(417, "部门不存在！"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    ROLE_RELATION_USER(501, "用户和角色存在着相互的关系!"),
    ROLE_RELATION_PERMISSION(502, "角色和权限存在相互关系！"),
    HTTP_REQUEST_METHOD(405, "Http请求方法不正常!"),

    ;

    private Integer code;
    private String message;

}
