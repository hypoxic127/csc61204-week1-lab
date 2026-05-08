package Week_3.task2_observer;

// Observer interface — all notification handlers implement this
public interface AdmissionObserver {
    void onPatientAdmitted(String patientName, int riskScore);
}
