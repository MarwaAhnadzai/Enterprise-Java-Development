package ca.sheridancollege.ahmamarw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DrinksReview8Application {

    public static void main(String[] args) {
        SpringApplication.run(DrinksReview8Application.class, args);
    }

}
