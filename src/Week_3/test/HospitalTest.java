package Week_3.test;

import Week_3.task2_observer.AdmissionObserver;
import Week_3.task2_observer.Hospital;

// Since JUnit is not currently configured in the project classpath, 
// here is a simple POJO Week_2.Week_2.test that acts as a standalone runner to verify the behavior
public class HospitalTest {

    // A Week_2.Week_2.test-specific observer that tracks if it was called
    static class TestObserver implements AdmissionObserver {
        boolean wasCalled = false;

        @Override
        public void onPatientAdmitted(String patientName, int riskScore) {
            wasCalled = true;
        }
    }

    public static void main(String[] args) {
        testObserverRemoval();
    }

    public static void testObserverRemoval() {
        Hospital hospital = new Hospital("Test Hospital");
        TestObserver testObserver = new TestObserver();

        System.out.println("Running testObserverRemoval...");

        // 1. Add observer and verify it gets called
        hospital.addObserver(testObserver);
        hospital.admitPatient("John Doe", 50);
        
        if (!testObserver.wasCalled) {
            throw new AssertionError("Test Failed: Observer should be called after being added.");
        }

        // 2. Reset flag
        testObserver.wasCalled = false;

        // 3. Remove observer and verify it does NOT get called
        hospital.removeObserver(testObserver);
        hospital.admitPatient("Jane Doe", 30);
        
        if (testObserver.wasCalled) {
            throw new AssertionError("Test Failed: Observer should NOT be called after being removed.");
        }

        System.out.println("Test Passed: Observer removal works correctly.");
    }
}
