package com.inflearn.spring.beanfind;

import com.inflearn.spring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinationNames=ac.getBeanDefinitionNames();
        for (String beanDefinationName : beanDefinationNames) {
            Object bean = ac.getBean(beanDefinationName);
            System.out.println("name="+beanDefinationName+" object="+bean);

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinationNames=ac.getBeanDefinitionNames();
        for (String beanDefinationName : beanDefinationNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinationName);

            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinationName);
                System.out.println("name="+beanDefinationName+" object="+bean);
            }

        }
    }
}
