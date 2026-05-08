package Week_3.task2_observer;

// Subject interface — the Hospital implements this
public interface AdmissionSubject {
    void addObserver(AdmissionObserver observer);
    void removeObserver(AdmissionObserver observer);
    void notifyObservers(String patientName, int riskScore);
}
