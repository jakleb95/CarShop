// package com.thebeans.game.oauth2;

// import java.util.Collections;

// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @PropertySource("classpath:application.properties")
// public class Ouath2Config {
    
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }


//     @Bean 
//     public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//     return new PropertySourcesPlaceholderConfigurer();
//     }

//     @Bean
//     public FilterRegistrationBean<JwtFilter> filterRegistrationBean() {
//         FilterRegistrationBean<JwtFilter>  filterRegistrationBean = new FilterRegistrationBean<>();
//         filterRegistrationBean.setFilter(new JwtFilter());
//         filterRegistrationBean.setUrlPatterns(Collections.singleton("/user/*"));
//         return filterRegistrationBean;
//     }
// }