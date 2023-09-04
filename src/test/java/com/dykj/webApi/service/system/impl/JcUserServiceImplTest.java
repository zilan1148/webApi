package com.dykj.webApi.service.system.impl;

import com.dykj.webApi.pojo.system.JcUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.portable.ValueBase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;



@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class JcUserServiceImplTest {


    @Resource
    private JcUserServiceImpl jcUserService;

    @Test
    public void testFindOneByUserId(){

        JcUser jcUser = this.jcUserService.findOneByUserId("2b28f07fbfaf459e934d3db80f5020dd");
        log.info("============>JcUser-->{}",jcUser);
    }

    @Test
    public void testFindOneByUsername(){
        JcUser test = this.jcUserService.findOneByUsername("test");
        log.info("============>JcUser-->{}",test);
    }

    @Test
    public void testBCryptPasswordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        log.info("========第一次====>加密密码123-->{}",encode);
        String encode1 = bCryptPasswordEncoder.encode("123");
        log.info("========第二次====>加密密码123-->{}",encode1);
    }
}
