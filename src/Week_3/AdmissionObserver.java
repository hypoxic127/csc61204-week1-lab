package Week_3;

// Observer interface — all notification handlers implement this
public interface AdmissionObserver {
    void onPatientAdmitted(String patientName, int riskScore);
}
