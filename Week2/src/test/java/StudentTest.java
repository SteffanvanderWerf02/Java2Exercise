import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.HashMap;

class StudentTest {

    public Student st1;
    public Student st2;
    public Student st3;


    @BeforeEach
    void setup() {
        //students
        st1 = new Student("Steffan", 34213, LocalDate.of(2002, 3, 3));
        st2 = new Student("Jan", 4321, LocalDate.of(2009, 2, 19));
        st3 = new Student("Martijn", 3, LocalDate.of(2001, 8, 30));

        //add subject To student
        st1.followSubject(new Subject("PHP"));
        st1.followSubject(new Subject("Java"));

        st2.followSubject(new Subject("Java"));

        st3.followSubject(new Subject("Java"));
        st3.followSubject(new Subject("PHP"));
        st3.followSubject(new Subject("JavaScript"));

        // add grade to subject
        st1.addGrade(5.4f, st1.getSubject("PHP"));
        st1.addGrade(6f, st1.getSubject("Java"));

        st2.addGrade(5.5f, st2.getSubject("Java"));

        st3.addGrade(5.5f, st3.getSubject("Java"));
        st3.addGrade(10f, st3.getSubject("PHP"));
        st3.addGrade(5.5f, st3.getSubject("JavaScript"));
    }

    @Test
    void getSubjectTest() {
        Subject subject = new Subject("PHP");
        assertNotEquals(subject,st3.getSubject("Wiskunde"), "the subject does not match");
    }

    @Test
    void getGradesTest() {
        HashMap<String, Float> grades = new HashMap<>();
        grades.put("PHP", 5.4f);
        grades.put("Java", 6f);
        assertEquals(grades,st1.getGrades(),"Your grades do not match");
    }

    @Test
    void findSubjectIfPresent() {
        Subject subject = new Subject("PHP");
        assertNotEquals(subject,st1.findSubjectIfPresent(subject));
    }
}