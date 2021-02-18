package com.udemy.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    public String getTraining() {
        return "Training session!!!";
    }

    public String getFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("TennisCoach: inside my doMyStartUpStuff()");
    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("TennisCoach: inside my doMyCleanUpStuff()");
    }


}
