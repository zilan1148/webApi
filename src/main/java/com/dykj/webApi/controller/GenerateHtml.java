package com.dykj.webApi.controller;

import com.dykj.webApi.bean.Result;
import com.dykj.webApi.directive.CmsContentListDirective;
import com.dykj.webApi.utils.FreeMarkerUtil;
import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:ctj
 * @date:2023/8/21
 * @Description:
 */
@RestController
@RequestMapping("/testGenerateHtml")
public class GenerateHtml {

    /**
     * 模板路径
     */
    @Value(value = "${freemarkerPath.templatePath}")
    private String templatePath;
    /**
     * 静态页路径
     */
    @Value(value = "${freemarkerPath.staticHtmlPath}")
    private String staticHtmlPath;

    @GetMapping("/test")
    public Result test() {
        Map<String,Object> map = new HashMap<>(16);
        map.put("repeat",new CmsContentListDirective());
        FreeMarkerUtil.createHtml("test2.ftl","test2.html",templatePath +"\\dykj",staticHtmlPath+"\\dy",map);
        return Result.success(map);
    }

    @GetMapping("/hello")
    public Result hello(){
        return Result.success("hello");
    }
}
 