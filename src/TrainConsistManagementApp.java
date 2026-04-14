import java.util.Arrays;

public class TrainConsistManagementApp {

    // Binary search method
    public static boolean binarySearchBogie(String[] bogieIds, String key) {

        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Ensure sorted order
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true;
            }
            else if (comparison < 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("===========================================\n");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        Arrays.sort(bogieIds);

        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");

        for(String id : bogieIds){
            System.out.println(id);
        }

        boolean found = binarySearchBogie(bogieIds, key);

        System.out.println();

        if(found){
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}