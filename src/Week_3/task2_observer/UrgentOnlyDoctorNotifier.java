package Week_3.task2_observer;

// Observer that only notifies if risk score >= 70
public class UrgentOnlyDoctorNotifier implements AdmissionObserver {
    private String doctorName;

    public UrgentOnlyDoctorNotifier(String doctorName) { 
        this.doctorName = doctorName; 
    }

    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        if (riskScore >= 70) {
            System.out.println("[Urgent Doctor " + doctorName + "] URGENT: Patient " + patientName
                + " admitted. Risk score: " + riskScore);
        }
    }
}
