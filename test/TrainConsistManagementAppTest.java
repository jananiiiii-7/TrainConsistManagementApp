import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {

        String[] bogies = {};

        assertThrows(
                IllegalStateException.class,
                () -> TrainConsistManagementApp.searchBogie(bogies, "BG101")
        );
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {

        String[] bogies = {"BG101","BG205"};

        boolean result = TrainConsistManagementApp.searchBogie(bogies, "BG101");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {

        String[] bogies = {"BG101","BG205","BG309"};

        boolean result = TrainConsistManagementApp.searchBogie(bogies, "BG205");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {

        String[] bogies = {"BG101","BG205","BG309"};

        boolean result = TrainConsistManagementApp.searchBogie(bogies, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_SingleElementValidCase() {

        String[] bogies = {"BG101"};

        boolean result = TrainConsistManagementApp.searchBogie(bogies, "BG101");

        assertTrue(result);
    }
}