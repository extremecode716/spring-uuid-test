package com.example.springuuid;

import com.example.springuuid.domain.Dept;
import com.example.springuuid.domain.DeptRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

// 소스코드: https://github.com/parkseungchul/j200/tree/master/j2021
// https://www.youtube.com/watch?v=KoAQOGoS-oA
// https://www.youtube.com/watch?v=eoAnhjemtAk&t=0s
@AllArgsConstructor
@SpringBootApplication
public class SpringUuidApplication {

    final DeptRepository deptRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringUuidApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {
        for (int i = 0; i < 10; ++i) {
            deptRepository.save(new Dept(i, String.valueOf(i), String.valueOf(i)));
        }
    }
}
