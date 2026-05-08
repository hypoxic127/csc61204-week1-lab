package Week_3;

// Observer 1: Notifies the doctor
public class DoctorNotifier implements AdmissionObserver {
    private String doctorName;
    public DoctorNotifier(String doctorName) { this.doctorName = doctorName; }

    @Override
    public void onPatientAdmitted(String patientName, int riskScore) {
        System.out.println("[Doctor " + doctorName + "] Patient " + patientName
            + " admitted. Risk score: " + riskScore);
    }
}
