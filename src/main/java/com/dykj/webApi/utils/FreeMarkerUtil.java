package com.dykj.webApi.utils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * @author:ctj
 * @date:2023/8/21
 * @Description:
 */
@Slf4j
@Component
public class FreeMarkerUtil {


    private static Configuration config;

    /**
     * 模板路径
     */
    @Value(value = "${freemarkerPath.templatePath}")
    private static String templatePath;

    /**
     * 静态页路径
     */
    @Value(value = "${freemarkerPath.staticHtmlPath}")
    private static String staticHtmlPath;

    /**
     * 通过freemarker生成静态HTML页面
     * @param templateName   模版名称
     * @param targetFileName 生成后的文件名
     * @param ftlPath        模板路径
     * @param htmlPath       路径
     * @param map            生成的数据都存储在MAP中
     */
    public static void createHtml(String templateName, String targetFileName, String ftlPath, String htmlPath, Map<String, Object> map) {
        try {
            //创建fm的配置
            config = new Configuration(Configuration.VERSION_2_3_28);
            //指定默认编码格式
            config.setDefaultEncoding("UTF-8");
            //设置模版文件的路径
            config.setDirectoryForTemplateLoading(new File(templatePath + ftlPath));
            //获得模版包
            Template template = config.getTemplate(templateName);
            //从参数文件中获取指定输出路径
            String path = staticHtmlPath + htmlPath;
            //生成的静态页存放路径如果不存在就创建
            File file = null;
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            //定义输出流，注意必须指定编码
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path + "/" + targetFileName))));
            //生成模版
            template.process(map, writer);
        } catch (Exception e) {
            log.error("生成异常：{}", e);
        }
    }
}
