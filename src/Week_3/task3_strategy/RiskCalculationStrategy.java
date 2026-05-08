package Week_3.task3_strategy;

// The strategy interface — different implementations = different algorithms
public interface RiskCalculationStrategy {
    int calculateRisk(double temperatureC, int age);
}
