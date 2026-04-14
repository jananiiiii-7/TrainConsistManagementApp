public class TrainConsistManagementApp {

    // Custom Exception
    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Bogie model
    static class Bogie {

        String type;
        int capacity;

        Bogie(String type, int capacity) throws InvalidCapacityException {

            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }

            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("===============================================\n");

        try {

            Bogie valid = new Bogie("Sleeper", 72);
            System.out.println("Created Bogie: " + valid.type + " -> " + valid.capacity);

            Bogie invalid = new Bogie("AC Chair", 0);

        } catch (InvalidCapacityException e) {

            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}