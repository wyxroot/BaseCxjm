package com.foresee.ss.dsp.rest.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 * TODO
 *
 * @author liuqiang@foresee.com.cn
 * @create 2018-11-05 14:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class getConfig {

    @Autowired
    private EurekaInstanceConfigBean eurekaInstanceConfigBean;

    @Autowired
    private ConfigClientProperties configClientProperties;


    @Test
    public void getConfig(){
        System.out.println(eurekaInstanceConfigBean);
        System.out.println(configClientProperties);
    }

}
