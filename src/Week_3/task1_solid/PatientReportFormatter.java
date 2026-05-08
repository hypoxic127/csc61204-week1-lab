package Week_3.task1_solid;

// Class 1: Only formats reports
public class PatientReportFormatter {
    public String format(String name, int riskScore) {
        return "Patient: " + name + " | Risk: " + riskScore;
    }
}
