package Week_3.task3_strategy;

// Strategy is injected via constructor (Dependency Injection)
public class PatientAdmissionV2 {

    private RiskCalculationStrategy strategy;

    public PatientAdmissionV2(RiskCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    // Allow swapping strategy at runtime
    public void setStrategy(RiskCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateRiskScore(double temperatureC, int age) {
        return strategy.calculateRisk(temperatureC, age);
    }
}
