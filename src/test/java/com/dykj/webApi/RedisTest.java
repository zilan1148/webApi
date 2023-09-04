package com.dykj.webApi;

import com.dykj.webApi.service.common.RedisUtilServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author:ctj
 * @date:2023/8/29
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {

    @Resource
    private RedisUtilServiceImpl redisUtilService;

    @Test
    public void test(){
        this.redisUtilService.set("test","value");

    }
}
