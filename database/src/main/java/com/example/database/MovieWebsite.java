package com.example.database;

import com.example.database.model.entity.User;
import com.example.database.service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

// CommandLineRunner: triển khai phương thức chỉ chạy 1 lần duy nhất trong cả vòng đời của ứng dụng


@SpringBootApplication(scanBasePackages = "com.example.database")
public class MovieWebsite {
    public static User user;

    @Autowired
    private MovieService movieService;

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(MovieWebsite.class, args);
    }

}
