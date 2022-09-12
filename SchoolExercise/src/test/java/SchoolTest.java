import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
class SchoolTest {

    public School school;

    public Student st1;
    public Student st2;
    public Student st3;


    @BeforeEach
    void setup() {
        //school
        school = new School("Stenden");

        //students
        st1 = new Student("Steffan", 34213, LocalDate.of(2002, 3, 3));
        st2 = new Student("Jan", 4321, LocalDate.of(2009, 2, 19));
        st3 = new Student("Martijn", 3, LocalDate.of(2001, 8, 30));

        //Subjects



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


        //add students to school
        school.addStudent(st1);
        school.addStudent(st2);
        school.addStudent(st3);
    }

    @Test
    void getStudentGrades() {
        HashMap<String, Float> list = new HashMap<>();
        Subject sub1 = new Subject("PHP");
        sub1.setGrade(5.4f);

        Subject sub2 = new Subject("Java");
        sub2.setGrade(6f);

        list.put(sub1.getName(),sub1.getGrade());
        list.put(sub2.getName(),sub2.getGrade());

        assertEquals(list,this.school.getStudentGrades(st1),"The Student grade list is not the same");
        assertNotEquals(list,this.school.getStudentGrades(st2),"The list does not match");

    }

    @Test
    void findStudentIfPresent() {
        assertEquals(st1,school.findStudentIfPresent(st1),"Your Student does not exitst in this school");
        assertNotEquals(st2,school.findStudentIfPresent(st3), "Studens do match");
    }

    @Test
    void getFailedStudents() {
        HashSet<Student> goodList = new HashSet<>();
        HashSet<Student> badList = new HashSet<>();

        goodList.add(st1);

        badList.add(st1);
        badList.add(st2);

        assertEquals(goodList,school.getFailedStudents(),"The list of failed students do not match");
        assertNotEquals(badList,school.getFailedStudents(),"The list of failed students do match");

    }
}