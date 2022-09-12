import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Student {

    private String name;
    private int number;
    private LocalDate birthDate;
    private HashSet subjects;

    public Student(String name, int number, LocalDate birthDate) {
        this.name = name;
        this.number = number;
        this.birthDate = birthDate;
        this.subjects = new HashSet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public HashSet getSubjects() {
        return subjects;
    }

    public void setSubjects(HashSet subjects) {
        this.subjects = subjects;
    }

    public void followSubject(Subject sub) {
        this.subjects.add(sub);
    }

    public void addGrade(float grade, Subject subject) {
        Subject sub = findSubjectIfPresent(subject);
        if (!sub.equals(null)) {
            sub.setGrade(grade);
        }
        
        sub.setGrade(0);
    }


    public Subject findSubjectIfPresent(Subject subject) {
        if (this.subjects.contains(subject)) {
            Iterator<Subject> it = this.subjects.iterator();
            while (it.hasNext()) {
                Subject sub = it.next();
                if (sub.equals(subject)) {
                    return sub;
                }
            }
        }
        return null;
    }

    public HashMap<String, Float> getGrades() {
        HashMap<String, Float> grades = new HashMap<>();

        Iterator<Subject> it = this.subjects.iterator();
        while (it.hasNext()) {
            Subject subject = it.next();
            grades.put(subject.getName(), subject.getGrade());
        }
        return grades;
    }


}