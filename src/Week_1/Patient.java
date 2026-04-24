package Week_1;

public class Patient {
    // Fields — data belonging to each Patient object
    String name;
    int age;
    double temperatureC;
    String bloodType;

    // Constructor — called when creating a new Patient
    public Patient(String name, int age, double temperatureC, String bloodType) {
        this.name = name;
        this.age = age;
        this.temperatureC = temperatureC;
        this.bloodType = bloodType;
    }

    // Method — behaviour of a Patient
    public void printSummary() {
        System.out.println("--- Patient Summary ---");
        System.out.println("Name:  " + this.name);
        System.out.println("Age:   " + this.age);
        System.out.println("Temp:  " + this.temperatureC + "°C");
        System.out.println("Blood: " + this.bloodType);
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Maria Santos", 45, 38.9, "O+");
        Patient p2 = new Patient("Ahmad Razali", 72, 37.1, "A-");
        p1.printSummary();
        p2.printSummary();
    }
}
