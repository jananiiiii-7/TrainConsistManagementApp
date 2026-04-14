import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // UC8 - Filter Bogies by Capacity
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {

        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // UC9 - Group Bogies by Type
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {

        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // UC10 - Count Total Seats using reduce()
    public static int calculateTotalSeats(List<Bogie> bogies) {

        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("===============================================\n");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");

        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Calculate total seats
        int totalSeats = calculateTotalSeats(bogies);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        System.out.println("\nUC10 aggregation completed...");
    }
}