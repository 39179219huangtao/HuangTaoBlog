package com.hyc.shop.product.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author: huangtao
 * @date: 2019/7/2
 */
@Configuration(value = "Swagger2")
@EnableSwagger2
public class Swagger2 {

    /**
     * @description: swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @param:
     * @return:
     * @author: huangtao
     * @date: 2019/7/2
     */
    @Bean(name = "restApi")
    public Docket createRestApi() {


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.hyc.shop"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @description: api文档的详细信息函数,注意这里的注解引用的是哪个
     * @param:
     * @return:
     * @author: huangtao
     * @date: 2019/7/2
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("hyc商城接口api文档")
                //创建人
                .contact(new Contact("黄涛", "", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
