import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student denise;
    private Student jan;


    @BeforeEach
    void setUp() {
        denise = new Student("Denise",3432, LocalDate.of(2001,02,12));
        jan = new Student("Jan",1234, LocalDate.of(1970,05,24));
    }

    /**
     * Test the method createUrlFriendlynName method
     */
    @Test
    void createUrlFriendlyName() {
        assertEquals("denise-12-02-2001", denise.createUrlFriendlyName());
        assertNotEquals("Denise 12-02-2001", denise.createUrlFriendlyName());

        assertEquals("jan-24-05-1970", jan.createUrlFriendlyName());
        assertNotEquals("Jan 24 05 1970", jan.createUrlFriendlyName());
    }

    /**
     * Test the method formatDateToString method
     */
    @Test
    void formatDateToStringTest() {
        assertEquals("24-05-1970",jan.formatDateToString());
        assertNotEquals("24-Mei-1970",jan.formatDateToString());
        assertNotEquals("1970-24-Mei",jan.formatDateToString());
    }
}