package com.dc.mspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 使用 @ServletComponentScan注解后，Servlet、Filter、Listener
 * 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码
 */
@SpringBootApplication
@ServletComponentScan
public class MspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspringbootApplication.class, args);
    }

}
