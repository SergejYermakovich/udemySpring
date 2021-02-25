package com.udemy.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args)   {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");

        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);

        System.out.println(coach.getFortune());
        System.out.println(coach.getTraining());

        context.close();
    }
}
