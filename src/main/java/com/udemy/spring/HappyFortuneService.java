package com.udemy.spring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{

    public String getFortune() {
        return "Happiness is key to success!!!";
    }
}
