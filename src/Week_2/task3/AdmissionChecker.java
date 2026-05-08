package Week_2.task3;

public class AdmissionChecker {
    public static void main(String[] args) {

        double bodyTempC = 38.9;  // Try different values

        // if/else: classify patient urgency
        if (bodyTempC >= 39.5) {
            System.out.println("URGENT: High fever — immediate admission required.");
        } else if (bodyTempC >= 37.5) {
            System.out.println("MODERATE: Elevated temperature — monitor closely.");
        } else {
            System.out.println("NORMAL: Temperature within safe range.");
        }

        // for loop: simulate checking 5 patients
        System.out.println("\nChecking daily patient queue:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("  Processing patient #" + i);
        }

        // while loop: countdown to ward close
        int hoursLeft = 3;
        System.out.println("\nWard closes in:");
        while (hoursLeft > 0) {
            System.out.println("  " + hoursLeft + " hour(s)");
            hoursLeft--;
        }
        System.out.println("  Ward closed.");
    }
}
