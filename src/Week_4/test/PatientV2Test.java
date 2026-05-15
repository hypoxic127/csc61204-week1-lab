package Week_4.test;

import Week_4.task3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientV2Test {

    @Test
    public void needsAlert_elderlyAlertConfig_alertsAtLowerThreshold() {
        PatientV2 elderlyPatient = new PatientV2(
                "Test Patient", 80, 38.1,
                new ElderlyAlert(), new StandardProtocol());
        
        // Elderly alert triggers at 38.0, so 38.1 should trigger an alert
        assertTrue(elderlyPatient.needsAlert());
    }

    @Test
    public void upgradeAlertConfig_newConfigApplied_thresholdChanges() {
        PatientV2 patient = new PatientV2(
                "Ahmad Razali", 72, 38.2,
                new ElderlyAlert(), new DiabeticProtocol());

        // Initial alert config triggers at 38.0, so 38.2 triggers an alert
        assertTrue(patient.needsAlert());
        assertEquals(38.0, patient.getAlertConfig().getThreshold(), 0.001);

        // Upgrade to PediatricAlert which triggers at 38.5
        patient.upgradeAlertConfig(new PediatricAlert());

        // Now the threshold is higher (38.5) so 38.2 should NO LONGER trigger an alert
        assertFalse(patient.needsAlert());
        assertEquals(38.5, patient.getAlertConfig().getThreshold(), 0.001);
    }
}
