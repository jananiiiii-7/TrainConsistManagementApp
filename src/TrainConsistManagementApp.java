import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class GoodsBogie {

        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {

        return bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical")
                                || b.cargo.equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("===============================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Goods Bogies in Train:");

        for (GoodsBogie b : bogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        boolean safe = checkSafetyCompliance(bogies);

        System.out.println("\nSafety Compliance Result: " + safe);

        System.out.println("\nUC12 safety validation completed...");
    }
}