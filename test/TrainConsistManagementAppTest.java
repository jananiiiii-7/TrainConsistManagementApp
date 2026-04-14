import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // UC8 TESTS

    @Test
    void testFilter_CapacityGreaterThanThreshold() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));

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


    // UC9 TESTS

    @Test
    void testGrouping_BogiesGroupedByType() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",70));

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2,result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class",24));

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2,result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }


    // UC10 TESTS

    @Test
    void testReduce_TotalSeatCalculation() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class",24));

        int result = TrainConsistManagementApp.calculateTotalSeats(bogies);

        assertEquals(152,result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));

        int result = TrainConsistManagementApp.calculateTotalSeats(bogies);

        assertEquals(72,result);
    }

    @Test
    void testReduce_EmptyBogieList() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int result = TrainConsistManagementApp.calculateTotalSeats(bogies);

        assertEquals(0,result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",70));

        int result = TrainConsistManagementApp.calculateTotalSeats(bogies);

        assertEquals(142,result);
    }

}