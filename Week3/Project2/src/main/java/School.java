import java.util.HashSet;

/**
 * Class of the school object
 */
public class School {

    private String name;
    private HashSet<Student> students;

    /**
     * Constructor of the school class
     * @param name name of the school
     */
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
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void setStudents(HashSet students) {
        this.students = students;
    }

    /***
     * Create URL friendly name from school name
     * @return returns string with url friendly name
     */
    public String createUrlFriendlyName() {
        return Edit.createUrl(this.getName());
    }
}