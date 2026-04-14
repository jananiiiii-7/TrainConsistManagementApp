import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testValidTrainID() {
        boolean result = TrainConsistManagementApp.validateTrainID("TRN-1234");
        assertTrue(result);
    }

    @Test
    void testInvalidTrainID() {
        boolean result = TrainConsistManagementApp.validateTrainID("TRAIN123");
        assertFalse(result);
    }

    @Test
    void testValidCargoCode() {
        boolean result = TrainConsistManagementApp.validateCargoCode("PET-AB");
        assertTrue(result);
    }

    @Test
    void testInvalidCargoCode() {
        boolean result = TrainConsistManagementApp.validateCargoCode("PET-ab");
        assertFalse(result);
    }

    @Test
    void testEmptyInputs() {
        boolean train = TrainConsistManagementApp.validateTrainID("");
        boolean cargo = TrainConsistManagementApp.validateCargoCode("");
        assertFalse(train);
        assertFalse(cargo);
    }
}