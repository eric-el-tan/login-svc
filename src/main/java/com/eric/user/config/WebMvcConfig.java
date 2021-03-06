package com.eric.user.config;

import io.swagger.annotations.ApiOperation;
//import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
//@EnableAsync
@Configuration
@EnableAutoConfiguration
//@ComponentScan
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String API_DESCRIPTION = "User module description<div>" +
            "<li>v1: Maintain user CRUD</li>" +
            "<li>v2: Calculating age of user</li>" +
            "</div>";
    private static final String API_VERSION = "1.0";
    private static final String API_TITLE_SYSTEM = "Simple Backend";
    private static final String API_TITLE_MODULE = "User";
    private static final String API_TITLE = API_TITLE_SYSTEM + " " + API_TITLE_MODULE + " " + "REST API";
    private static final String CONTACT_DEVELOPER = "Developer";
    private static final String CONTACT_URL = "eric.org";
    private static final String CONTACT_EMAIL = "eric@org.nz";
    private static final String LICENSE_TEXT = "License";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";
    private static final String TERMS_OF_SERVICE_URL = "http://localhost:9001/swagger-ui.html";


    private ApiInfo apiInfo(){
        final ApiInfo build = new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .license(LICENSE_TEXT)
                .licenseUrl(LICENSE_URL)
                .termsOfServiceUrl(TERMS_OF_SERVICE_URL)
                .contact(new Contact(CONTACT_DEVELOPER, CONTACT_URL, CONTACT_EMAIL))
                .build();
        return build;
    }
    
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("Header - token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

//    @Bean
//    public DozerBeanMapper dozerBeanMapper() {
//        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
//        dozerBeanMapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml")); // support jdk8 LocalDateTime
////        dozerBeanMapper.setMappingFiles(
////                Arrays.asList("dozerJdk8Converters.xml",    // support jdk8 LocalDateTime
////                        "dozer_mapping.xml"));              // map po and dto
//        return dozerBeanMapper;
//    }

//    @Bean
//    public ReentrantLock confirmAppointmentLock() {
//        ReentrantLock lock = new ReentrantLock();
//        return lock;
//    }

//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(5000);//ms
//        factory.setConnectTimeout(15000);//ms
//        return factory;
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations(
//                "classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
//                "classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations(
//                "classpath:/META-INF/resources/webjars/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }

}
