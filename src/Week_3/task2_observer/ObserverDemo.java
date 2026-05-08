package Week_3.task2_observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("MediTrack Central");

        // Register initial observers
        // Replaced standard doctor with UrgentOnlyDoctorNotifier
        hospital.addObserver(new UrgentOnlyDoctorNotifier("Dr. Lim"));
        hospital.addObserver(new BillingNotifier());
        hospital.addObserver(new AuditNotifier());

        // Create the new nurse observer
        WardNurseNotifier nurseNotifier = new WardNurseNotifier();

        // 1. Add the nurse observer
        System.out.println("--- Round 1: Admitting URGENT Patient (Risk: 80) ---");
        hospital.addObserver(nurseNotifier);
        hospital.admitPatient("Maria Santos", 80);

        System.out.println("\n--- Round 2: Admitting ROUTINE Patient (Risk: 25) ---");
        // 2. Remove the nurse observer
        hospital.removeObserver(nurseNotifier);
        hospital.admitPatient("Ahmad Razali", 25);
    }
}
