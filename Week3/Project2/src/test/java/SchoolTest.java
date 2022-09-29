import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    private School nhlStenden;
    private School hanze;

    @BeforeEach
    void setUp() {
        nhlStenden = new School("NHL Stenden");
        hanze = new School("Hanzen Hogeschool");
    }

    /***
     * Test functionality of the createUrlFriendlyname method
     */
    @Test
    void createUrlFriendlyName() {
        assertEquals("nhl-stenden", nhlStenden.createUrlFriendlyName());
        assertNotEquals("NHL Stenden", nhlStenden.createUrlFriendlyName());

        assertEquals("hanzen-hogeschool", hanze.createUrlFriendlyName());
        assertNotEquals("Hanzen Hogeschool", hanze.createUrlFriendlyName());
    }
}