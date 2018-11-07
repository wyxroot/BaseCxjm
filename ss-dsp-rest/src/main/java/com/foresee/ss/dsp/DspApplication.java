/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */
package com.foresee.ss.dsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <pre>
 * 示例应用程序启动类。。
 * </pre>
 *
 * @author linxj@foresee.com.cn
 * @date 2017年08月03日
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录 
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 */
@SpringBootApplication(scanBasePackages = { "com.foresee" }, exclude = { DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class })
@EnableEurekaClient
public class DspApplication {

    public static void main(String[] args) {
        SpringApplication.run(DspApplication.class, args);
    }

}
