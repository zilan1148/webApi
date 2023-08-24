package com.dykj.webApi.controller;

import com.dykj.webApi.bean.Result;
import com.dykj.webApi.pojo.GenerateHtmlPojo;
import com.dykj.webApi.utils.FreeMarkerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:ctj
 * @date:2023/8/21
 * @Description:
 */
@RestController
@RequestMapping("/testgenerateHtml")
public class GenerateHtml {

    @GetMapping("/test")
    public Result test() {
        Map<String,Object> map = new HashMap<>(16);
        List<GenerateHtmlPojo> list = new ArrayList<>();
        list.add(new GenerateHtmlPojo("床前明月光，", "疑是地上霜。"));
        list.add(new GenerateHtmlPojo("举头望明月，", "低头思故乡。"));
        map.put("author","李白");
        map.put("test",list);
        FreeMarkerUtil.createHtml("test.ftl","test.html","\\ftl","\\html",map);
        return Result.success(map);
    }
}
