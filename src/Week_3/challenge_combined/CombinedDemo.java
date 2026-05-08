package Week_3.challenge_combined;

import Week_3.task2_observer.AuditNotifier;
import Week_3.task2_observer.UrgentOnlyDoctorNotifier;
import Week_3.task2_observer.WardNurseNotifier;
import Week_3.task3_strategy.ConservativeRiskStrategy;

public class CombinedDemo {
    public static void main(String[] args) {
        // 1. Create a Hospital with a ConservativeRiskStrategy
        HospitalWithStrategy hospital = new HospitalWithStrategy(
                "MediTrack Advanced", 
                new ConservativeRiskStrategy()
        );

        // 2. Register three observers
        hospital.addObserver(new UrgentOnlyDoctorNotifier("Dr. Strange"));
        hospital.addObserver(new WardNurseNotifier());
        hospital.addObserver(new AuditNotifier());

        System.out.println("=== Admitting Patient 1 (Critical Case) ===");
        // Temp: 38.6 (Conservative strategy gives 50), Age: 65 (gives 30). Total Risk: 80
        // Because risk is 80 (>= 70), the UrgentOnlyDoctorNotifier WILL trigger.
        hospital.admitPatient("Arthur Pendragon", 38.6, 65);

        System.out.println("\n=== Admitting Patient 2 (Routine Case) ===");
        // Temp: 37.1 (Conservative gives 25), Age: 45 (gives 0). Total Risk: 25
        // Because risk is 25 (< 70), the UrgentOnlyDoctorNotifier will NOT trigger.
        hospital.admitPatient("Merlin", 37.1, 45);
    }
}
