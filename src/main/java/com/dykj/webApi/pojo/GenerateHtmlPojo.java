package com.dykj.webApi.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:ctj
 * @date:2023/8/21
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateHtmlPojo implements Serializable {

    private String first;

    private String second;

    private static final long serialVersionUID = 1L;

}
