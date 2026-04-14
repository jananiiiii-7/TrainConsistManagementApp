import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Loop based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {

        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // Stream based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {

        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("===============================================\n");

        // Create dataset
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
        }

        // Loop benchmark
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long loopEnd = System.nanoTime();

        long loopTime = loopEnd - loopStart;

        // Stream benchmark
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long streamEnd = System.nanoTime();

        long streamTime = streamEnd - streamStart;

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}