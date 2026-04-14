import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistManagementApp.InvalidCapacityException {

        TrainConsistManagementApp.Bogie bogie =
                new TrainConsistManagementApp.Bogie("Sleeper",72);

        assertEquals("Sleeper",bogie.type);
        assertEquals(72,bogie.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {

        assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Sleeper",-10)
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {

        assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("AC Chair",0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {

        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.Bogie("Sleeper",0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagementApp.InvalidCapacityException {

        TrainConsistManagementApp.Bogie bogie =
                new TrainConsistManagementApp.Bogie("First Class",24);

        assertEquals("First Class",bogie.type);
        assertEquals(24,bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistManagementApp.InvalidCapacityException {

        TrainConsistManagementApp.Bogie b1 =
                new TrainConsistManagementApp.Bogie("Sleeper",72);

        TrainConsistManagementApp.Bogie b2 =
                new TrainConsistManagementApp.Bogie("AC Chair",56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}