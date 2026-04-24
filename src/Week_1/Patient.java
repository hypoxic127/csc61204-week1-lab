package Week_1;

public class Patient {
    // Fields — data belonging to each Patient object
    String name;
    int age;
    double temperatureC;
    String bloodType;
    boolean isAdmitted;

    // Constructor — called when creating a new Patient
    public Patient(String name, int age, double temperatureC, String bloodType, boolean isAdmitted) {
        this.name = name;
        this.age = age;
        this.temperatureC = temperatureC;
        this.bloodType = bloodType;
        this.isAdmitted = isAdmitted;
    }
    // Constructor2 — called when creating a new Patient
    public Patient(String name, int age, double temperatureC, String bloodType) {
        this.name = name;
        this.age = age;
        this.temperatureC = temperatureC;
        this.bloodType = bloodType;
        this.isAdmitted = false;
    }





    //Method - temperature detect
    public String assessRisk() {
        if (this.temperatureC >= 39.5) return "HIGH";
        if (this.temperatureC >= 37.5) return "MODERATE";
        return "LOW";
    }

    // Method — behaviour of a Patient
    public void printSummary() {
        System.out.println("--- Patient Summary ---");
        System.out.println("Name:  " + this.name);
        System.out.println("Age:   " + this.age);
        System.out.println("Temp:  " + this.temperatureC + "°C");
        System.out.println("Blood: " + this.bloodType);
        System.out.println("Risk Level: " + this.assessRisk());
        System.out.println("Admitted: " + this.isAdmitted);
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Maria Santos", 45, 38.9, "O+");
        Patient p2 = new Patient("Ahmad Razali", 72, 37.1, "A-");

        Patient p3 = new Patient("Student Name", 20, 39.6, "B+", true);
        p1.printSummary();
        p2.printSummary();
        p3.printSummary();
    }
}
