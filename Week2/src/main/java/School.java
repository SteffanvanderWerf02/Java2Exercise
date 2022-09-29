import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class School {

    private String name;
    private HashSet<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new HashSet<Student>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void setStudents(HashSet students) {
        this.students = students;
    }

    public HashMap<String, Float> getStudentGrades(Student student) {
        Student curStudent = findStudentIfPresent(student);
        if (!curStudent.equals(null)) {
            return curStudent.getGrades();
        }

        return null;
    }

    public Student findStudentIfPresent(Student student) {
        if (this.students.contains(student)) {
            Iterator<Student> it = this.students.iterator();
            while (it.hasNext()) {
                Student stu = it.next();
                if (stu.equals(student)) {
                    return stu;
                }
            }
        }
        return null;
    }

    public HashSet<Student> getFailedStudents() {
        HashSet<Student> failedStudents = new HashSet<>();

        if (!this.students.isEmpty()) {
            Iterator<Student> it = this.students.iterator();
            while (it.hasNext()) {
                Student student = it.next();

                HashMap<String, Float> grades = this.getStudentGrades(student);
                for (String key : grades.keySet()) {
                    float grade = grades.get(key);
                    if (grade < 5.5) {
                        failedStudents.add(student);
                        break;
                    }
                }
            }
        }
        return failedStudents;
    }
}