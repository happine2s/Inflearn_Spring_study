package com.inflearn.spring.singleton;

public class SingletonService {
    private static final SingletonService instance=new SingletonService(); // 자바의 static 영역

    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private으로 선언해서 외부에서 new로 새로운 객체 생성을 막음
    private  SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
