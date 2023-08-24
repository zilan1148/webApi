package com.dykj.webApi.directive;


import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author:ctj
 * @date:2023/8/22
 * @Description: 自定义标签之新闻列表
 */
@Component
public class CmsContentListDirective implements TemplateDirectiveModel {

    /**
     * 模板名称
     */
    public static final String TPL_NAME = "content_list";

    /**
     * 输入参数，文章ID。允许多个文章ID，用","分开。排斥其他所有筛选参数。
     */
    public static final String PARAM_IDS = "ids";


    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

    }
}
