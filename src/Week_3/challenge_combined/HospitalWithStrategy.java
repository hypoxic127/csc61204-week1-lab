package Week_3.challenge_combined;

import java.util.ArrayList;
import java.util.List;
import Week_3.task2_observer.AdmissionObserver;
import Week_3.task2_observer.AdmissionSubject;
import Week_3.task3_strategy.RiskCalculationStrategy;

// A new Hospital class that combines Observer and Strategy patterns
public class HospitalWithStrategy implements AdmissionSubject {

    private List<AdmissionObserver> observers = new ArrayList<>();
    private RiskCalculationStrategy riskStrategy;
    private String hospitalName;

    // Strategy is injected via the constructor
    public HospitalWithStrategy(String hospitalName, RiskCalculationStrategy strategy) {
        this.hospitalName = hospitalName;
        this.riskStrategy = strategy;
    }

    @Override
    public void addObserver(AdmissionObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AdmissionObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String patientName, int riskScore) {
        for (AdmissionObserver observer : observers) {
            observer.onPatientAdmitted(patientName, riskScore);
        }
    }

    // This method now uses the strategy to calculate risk before notifying observers
    public void admitPatient(String patientName, double temperatureC, int age) {
        System.out.println("[" + hospitalName + "] Admitting: " + patientName);
        
        // 1. Use the injected strategy to calculate risk
        int riskScore = riskStrategy.calculateRisk(temperatureC, age);
        
        // 2. Notify all observers with the calculated risk
        notifyObservers(patientName, riskScore);
    }
}
