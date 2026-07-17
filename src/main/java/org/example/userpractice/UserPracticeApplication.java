package org.example.userpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UserPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserPracticeApplication.class, args);
    }

}
