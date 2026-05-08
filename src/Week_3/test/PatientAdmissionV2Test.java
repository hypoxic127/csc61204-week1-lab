package Week_3.test;

import Week_3.task3_strategy.ConservativeRiskStrategy;
import Week_3.task3_strategy.PatientAdmissionV2;
import Week_3.task3_strategy.PediatricRiskStrategy;
import Week_3.task3_strategy.StandardRiskStrategy;

// Using a custom POJO Week_2.Week_2.test class since standard JUnit was missing earlier
public class PatientAdmissionV2Test {

    public static void main(String[] args) {
        testDifferentStrategiesProduceDifferentScores();
        testSetStrategyChangesBehavior();
        testOpenClosedPrincipleWithPediatricStrategy();
        
        System.out.println("All Strategy tests passed successfully!");
    }

    public static void testDifferentStrategiesProduceDifferentScores() {
        double temp = 38.7;
        int age = 62;

        PatientAdmissionV2 standard = new PatientAdmissionV2(new StandardRiskStrategy());
        PatientAdmissionV2 conservative = new PatientAdmissionV2(new ConservativeRiskStrategy());

        // Standard: temp >= 37.5 (+25), age < 65 (+0) = 25
        int standardScore = standard.calculateRiskScore(temp, age);
        if (standardScore != 25) {
            throw new AssertionError("Standard score failed. Expected 25, got " + standardScore);
        }

        // Conservative: temp >= 38.5 (+50), age >= 60 (+30) = 80
        int conservativeScore = conservative.calculateRiskScore(temp, age);
        if (conservativeScore != 80) {
            throw new AssertionError("Conservative score failed. Expected 80, got " + conservativeScore);
        }

        System.out.println("✔ testDifferentStrategiesProduceDifferentScores passed");
    }

    public static void testSetStrategyChangesBehavior() {
        double temp = 38.7;
        int age = 62;

        PatientAdmissionV2 patient = new PatientAdmissionV2(new StandardRiskStrategy());
        
        int initialScore = patient.calculateRiskScore(temp, age);
        if (initialScore != 25) {
            throw new AssertionError("Initial standard score failed. Expected 25, got " + initialScore);
        }

        // Swap strategy
        patient.setStrategy(new ConservativeRiskStrategy());
        int updatedScore = patient.calculateRiskScore(temp, age);
        
        if (updatedScore != 80) {
            throw new AssertionError("Updated conservative score failed. Expected 80, got " + updatedScore);
        }

        System.out.println("✔ testSetStrategyChangesBehavior passed");
    }

    public static void testOpenClosedPrincipleWithPediatricStrategy() {
        double temp = 38.2;
        int age = 8;

        // Creating the new Pediatric strategy and injecting it into the EXISTING PatientAdmissionV2 class
        PatientAdmissionV2 pediatricPatient = new PatientAdmissionV2(new PediatricRiskStrategy());

        // Pediatric: age < 12 (+20), temp >= 38.0 (+40) = 60
        int pediatricScore = pediatricPatient.calculateRiskScore(temp, age);
        
        if (pediatricScore != 60) {
            throw new AssertionError("Pediatric score failed. Expected 60, got " + pediatricScore);
        }

        System.out.println("✔ testOpenClosedPrincipleWithPediatricStrategy passed");
    }
}
