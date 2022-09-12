import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class SchoolTest {

    private School school;

    private Student st1;
    private Student st2;
    private Student st3;

    private Subject sub1;
    private Subject sub2;
    private Subject sub3;

    @BeforeEach
    void setup() {
        //school
        School school = new School("Stenden");

        //students
        Student st1 = new Student("Steffan", 34213, LocalDate.of(2002, 3, 3));
        Student st2 = new Student("Jan", 4321, LocalDate.of(2009, 2, 19));
        Student st3 = new Student("Martijn", 3, LocalDate.of(2001, 8, 30));

        //Subjects

        Subject sub1 = new Subject("Java");
        Subject sub2 = new Subject("Php");
        Subject sub3 = new Subject("Javascript");

        //add subject To student
        st1.followSubject(sub1);
        st1.followSubject(sub3);

        st2.followSubject(sub2);

        st3.followSubject(sub1);
        st3.followSubject(sub2);
        st3.followSubject(sub3);

        // add grade to subject
        st1.addGrade(5.4f, sub1);
        st1.addGrade(6f, sub3);

        st2.addGrade(5.5f, sub2);

        st3.addGrade(5.5f, sub2);
        st3.addGrade(10f, sub1);
        st3.addGrade(5.5f, sub3);


        //add students to school
        school.addStudent(st1);
        school.addStudent(st2);
        school.addStudent(st3);
    }

    @Test
    void getStudentGrades() {
    }

    @Test
    void findStudentIfPresent() {
    }

    @Test
    void getFailedStudents() {
    }
}