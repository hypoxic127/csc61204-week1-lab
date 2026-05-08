package Week_3.task2_observer;

// Observer 4: Notifies the ward nurse
public class WardNurseNotifier implements AdmissionObserver {
    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        System.out.println("[Ward Nurse] Preparing a bed for: " + patientName);
    }
}
