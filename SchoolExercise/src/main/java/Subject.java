public class Subject    {
    private String name;
    private float grade;

    public Subject(String name) {
        this.name = name;
        this.grade = 0;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}