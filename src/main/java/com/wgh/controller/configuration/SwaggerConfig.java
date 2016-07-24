package com.wgh.controller.configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by kavin on 16/7/20.
 */

@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("com.wgh.controller")
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    public static String PROJECT_NAME;

    static {
        PROJECT_NAME = "dfinance";
    }
    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation(){
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo());
               /* .includePatterns(".*//*test.*").;*/
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "Dfinance Application Documents",
            "This is a document for dfinance application",
            "Finance System Team",
            "kevin@imdada.cn",
            "Apache Liscence",
            "http://localhost:8080/api-docs/");
        return apiInfo;
    }

}
