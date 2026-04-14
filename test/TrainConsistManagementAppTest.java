import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicSorting() {

        int[] data = {72, 56, 24, 70, 60};

        TrainConsistManagementApp.bubbleSort(data);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, data);
    }

    @Test
    void testSort_AlreadySortedArray() {

        int[] data = {24, 56, 60, 70, 72};

        TrainConsistManagementApp.bubbleSort(data);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, data);
    }

    @Test
    void testSort_DuplicateValues() {

        int[] data = {72, 56, 56, 24};

        TrainConsistManagementApp.bubbleSort(data);

        assertArrayEquals(new int[]{24, 56, 56, 72}, data);
    }

    @Test
    void testSort_SingleElementArray() {

        int[] data = {50};

        TrainConsistManagementApp.bubbleSort(data);

        assertArrayEquals(new int[]{50}, data);
    }

    @Test
    void testSort_AllEqualValues() {

        int[] data = {40, 40, 40};

        TrainConsistManagementApp.bubbleSort(data);

        assertArrayEquals(new int[]{40, 40, 40}, data);
    }
}