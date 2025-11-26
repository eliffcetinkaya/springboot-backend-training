package com.example.demo.member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MemberConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemberRepository repository) {
        return args -> {
            Member elif = new Member(
                    "elifcetinkaya",
                    "Elif",
                    "elif@gmail.com",
                    LocalDate.of(2004, Month.AUGUST, 24),
                    MemberType.STUDENT,
                    List.of(new Feature("gpa","3.6",FeatureType.ACADEMIC),
                            new Feature("major","cs",FeatureType.ACADEMIC))
            );
            Member alex = new Member(
                    "alex",
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 12),
                    MemberType.TEACHER,
                    List.of(new Feature("field","math",FeatureType.WORK),
                            new Feature("numberOfClass","5",FeatureType.WORK),
                            new Feature("height","1.78",FeatureType.PHYSICAL),
                            new Feature("weight", "80",FeatureType.PHYSICAL))
            );
            Member jeffrey = new Member(
                    "jeff",
                    "Jeffrey",
                    "jeff@gmail.com",
                    LocalDate.of(1985, Month.APRIL, 13),
                    MemberType.STAFF,
                    List.of(new Feature("role","cleaning",FeatureType.WORK),
                            new Feature("type","part-time",FeatureType.WORK))
            );
            repository.saveAll(
                    List.of(elif, alex, jeffrey)
            );
        };
    }
}