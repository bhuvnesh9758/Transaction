package com.springjpa.springjpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class SpringJpaApplication {

    public static void main(String[] args)  {
        TopicService obj1 = new TopicService();
        TopicService obj2 = new TopicService();
        TopicService obj3 = new TopicService();
        obj1.start();
        obj2.start();
        obj3.start();
        SpringApplication.run(SpringJpaApplication.class, args);
    }
}
