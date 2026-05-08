package Week_3.task2_observer;

// Observer 3: Logs the admission
public class AuditNotifier implements AdmissionObserver {
    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        System.out.println("[Audit Log] " + patientName + " admitted at "
            + java.time.LocalTime.now());
    }
}
