package Week_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Start MediTrack system =====");

        System.out.println("\n--- Running Patient test ---");
        Patient.main(args);

        // 调用 PatientRoster 类的测试逻辑
        System.out.println("\n--- Running PatientRoster test ---");
        PatientRoster.main(args);

        System.out.println("\n===== All test complete =====");
    }
}