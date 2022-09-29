import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class student that represents real student
 */
public class Student {

    private String name;
    private int number;
    private LocalDate birthDate;
    private final int MAX_AMOUNT_OF_SUBJECTS = 10;

    /**
     * Constructor of student class
     * @param name name of student
     * @param number studentnumber of student
     * @param birthDate date of birth of the student.
     */
    public Student(String name, int number, LocalDate birthDate) {
        this.name = name;
        this.number = number;
        this.birthDate = birthDate;
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

    /***
     * Format date to Europe date format
     * @return Returns string with europese date format
     */
    public String formatDateToString() {
        return this.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    /***
     * Create URL friendly name from Student name
     * @return returns string with url friendly name
     */
    public String createUrlFriendlyName() {
        return Edit.createUrl(this.getName() + " " + this.formatDateToString());
    }

}