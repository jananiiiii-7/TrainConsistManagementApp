import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies,60);

        assertEquals(1,result.size());
    }

    @Test
    void testFilter_EmptyList() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies,60);

        assertTrue(result.isEmpty());
    }
}