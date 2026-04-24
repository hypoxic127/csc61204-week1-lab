package Week_1;

public class PatientRoster {
    public static void main(String[] args) {

        Patient[] roster = new Patient[5];
        roster[0] = new Patient("Maria", 45, 38.9, "O+", true);
        roster[1] = new Patient("Ahmad", 72, 37.1, "A-", false);
        roster[2] = new Patient("John", 30, 39.8, "B+", true); // 高烧
        roster[3] = new Patient("Sarah", 25, 36.5, "AB-", false);
        roster[4] = new Patient("Mike", 50, 38.0, "O-", true);

        // start variable
        double maxTemp = 0.0;
        String maxTempName = "";
        int highRiskCount = 0;

        System.out.println("=== EverydayPatientCheck ===");

        for (int i = 0; i < roster.length; i++) {

            roster[i].printSummary();


            if (roster[i].temperatureC > maxTemp) {
                maxTemp = roster[i].temperatureC;
                maxTempName = roster[i].name;
            }

            if (roster[i].assessRisk().equals("HIGH")) {
                highRiskCount++;
            }
        }


        System.out.println("\n=== Report ===");
        System.out.println("MaxTempPatient: " + maxTempName + " (" + maxTemp + "°C)");
        System.out.println("Total HR Patient: " + highRiskCount);
    }
}
