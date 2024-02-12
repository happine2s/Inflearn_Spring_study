package com.inflearn.spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //threadA: userA 10000원 주문
        int userPrice = statefulService1.order("userA",10000);
        //threadB: userB 10000원 주문
        statefulService2.order("userB",20000);

        //threadA: userA 주문 금액 조회
        //int price=statefulService1.getPrice();
        System.out.println("price="+userPrice);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}