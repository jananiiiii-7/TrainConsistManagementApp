import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

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
    void testGrouping_MultipleBogiesInSameGroup() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",60));

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2,result.get("AC Chair").size());
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

    @Test
    void testGrouping_SingleBogieCategory() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(1,result.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class",24));

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",70));

        Map<String,List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2,result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {

        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",56));

        int originalSize = bogies.size();

        TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(originalSize,bogies.size());
    }
}