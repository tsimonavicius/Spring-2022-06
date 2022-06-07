package lt.codeacademy.eshop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DIExample {

    @Test
    void simpleJavaDI() {
        System.out.println("Pazymiu vidurkis: " +
                new GradeService(new GradeRepo()).average());
    }
}

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