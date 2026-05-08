package Week_3.task3_strategy;

// A new strategy demonstrating OCP: added without modifying PatientAdmissionV2
public class PediatricRiskStrategy implements RiskCalculationStrategy {
    @Override
    public int calculateRisk(double temperatureC, int age) {
        int score = 0;
        if (age < 12) score += 20;
        if (temperatureC >= 38.0) score += 40;
        return score;
    }
}
