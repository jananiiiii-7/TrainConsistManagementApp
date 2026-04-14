public class TrainConsistManagementApp {

    // Search method with validation
    public static boolean searchBogie(String[] bogieIds, String searchId) {

        // Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        boolean found = false;

        for (String id : bogieIds) {

            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        return found;
    }

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("============================================\n");

        // Create bogie array (empty train scenario)
        String[] bogieIds = {};

        String searchId = "BG101";

        // Fail-fast validation
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        boolean found = searchBogie(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found.");
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}