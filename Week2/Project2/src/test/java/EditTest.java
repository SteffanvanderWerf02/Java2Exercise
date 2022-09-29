import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditTest {

    private String dirtyUrl;
    private String cleanUrl = "steffan-van-der-werf";
    private Edit edit;
    @BeforeEach
    void setUp() {
        dirtyUrl = "Steffan van der Werf!.?,";
    }

    @Test
    void createUrlWithoutSpacesTest() {
        assertEquals(cleanUrl, Edit.createUrl(dirtyUrl),"There is an Space not replaced");
    }

    @Test
    void createUrlWithoutQuestionmarkTest() {
        assertEquals(cleanUrl, Edit.createUrl(dirtyUrl),"There is an Questionmark not replaced");
    }

    @Test
    void createUrlWithoutDotTest() {
        assertEquals(cleanUrl, Edit.createUrl(dirtyUrl),"There is an Dot not replaced");
    }

    @Test
    void createUrlWithoutCommaTest() {
        assertEquals(cleanUrl, Edit.createUrl(dirtyUrl),"There is an Comma not replaced");
    }

    @Test
    void createUrlWithoutExplemationTest() {
        assertEquals(cleanUrl, Edit.createUrl(dirtyUrl),"There is an Explemation point not replaced");
    }

}