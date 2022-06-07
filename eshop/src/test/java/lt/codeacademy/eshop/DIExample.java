package lt.codeacademy.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

public class DIExample {

    @Test
    void simpleJavaDI() {
        System.out.println("Pazymiu vidurkis: " +
                new GradeService(new GradeRepo()).average());
    }

    @Test
    void DIWithSpring() {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringContextConfig.class);

        System.out.println("Pazymiu vidurkis: " +
                springContext.getBean(GradeService.class).average());
    }
}

@Service
class GradeService {

    private final GradeRepo gradeRepo;

    public GradeService(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    public Double average() {
        List<Integer> grades = gradeRepo.getGrades();

        double sum = 0;

        for (Integer grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}

class GradeRepo {

    public List<Integer> getGrades() {
        return Arrays.asList(8, 10, 9, 7, 3, 8, 10);
    }
}

@ComponentScan
@Configuration
class SpringContextConfig {

    @Bean
    public GradeRepo createGradeRepo() {
        return new GradeRepo();
    }
}