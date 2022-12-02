package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    /*Esta clase filtra y maneja la internacionalización
    de la página web*/
    
    @Bean
    public SessionLocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale ("es"));
        return slr;
    } 
    
    @Bean
    public LocaleChangeInterceptor localeChangeinterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeinterceptor());
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){ //Registro de vistas que no tienen que pasar por un controlador
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
