import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testLoopFilteringLogic() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingLoop(bogies);

        assertEquals(1,result.size());
    }

    @Test
    void testStreamFilteringLogic() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(bogies);

        assertEquals(1,result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class",24));

        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterUsingLoop(bogies);

        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterUsingStream(bogies);

        assertEquals(loopResult.size(),streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {

        long start = System.nanoTime();

        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for(int i=0;i<10000;i++){
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        }

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(bogies);

        assertTrue(result.size() > 0);
    }
}