package Week_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Start MediTrack system =====");

        System.out.println("\n--- Running Patient Week_2.Week_2.test ---");
        Patient.main(args);

        // 调用 PatientRoster 类的测试逻辑
        System.out.println("\n--- Running PatientRoster Week_2.Week_2.test ---");
        PatientRoster.main(args);

        System.out.println("\n===== All Week_2.Week_2.test complete =====");
    }
}