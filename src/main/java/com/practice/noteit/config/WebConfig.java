package com.practice.noteit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration 
@EnableWebMvc
@ComponentScan(basePackages= {"com.practice.noteit.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{

}
