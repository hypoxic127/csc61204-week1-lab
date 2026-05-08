package Week_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientAdmissionTest {
    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    // --- calculateRiskScore tests ---
    @Test
    void calculateRiskScore_highTempElderlyPatient_returnsHighScore() {
        int score = admission.calculateRiskScore(40.0, 70);
        assertEquals(80, score);
    }

    @Test
    void calculateRiskScore_normalTempYoungPatient_returnsZero() {
        int score = admission.calculateRiskScore(36.5, 25);
        assertEquals(0, score);
    }

    @Test
    void calculateRiskScore_elevatedTempMiddleAge_returnsMediumScore() {
        int score = admission.calculateRiskScore(38.0, 55);
        assertEquals(40, score);
    }

    @Test
    void calculateRiskScore_tempExactly39point5_returnsFifty() {
        int score = admission.calculateRiskScore(39.5, 25);
        assertEquals(50, score);
    }

    @Test
    void calculateRiskScore_ageExactly65_returnsThirty() {
        int score = admission.calculateRiskScore(36.5, 65);
        assertEquals(30, score);
    }

    // --- getAdmissionPriority tests ---
    @Test
    void getAdmissionPriority_scoreAbove70_returnsUrgent() {
        assertEquals("URGENT", admission.getAdmissionPriority(80));
    }

    @Test
    void getAdmissionPriority_scoreBetween30And70_returnsModerate() {
        assertEquals("MODERATE", admission.getAdmissionPriority(40));
    }

    @Test
    void getAdmissionPriority_scoreBelow30_returnsRoutine() {
        assertEquals("ROUTINE", admission.getAdmissionPriority(10));
    }

    // --- isValidPatientName tests ---
    @Test
    void isValidPatientName_validName_returnsTrue() {
        assertTrue(admission.isValidPatientName("Maria Santos"));
    }

    @Test
    void isValidPatientName_nullName_returnsFalse() {
        assertFalse(admission.isValidPatientName(null));
    }

    @Test
    void isValidPatientName_emptyString_returnsFalse() {
        assertFalse(admission.isValidPatientName(""));
    }

    @Test
    void isValidPatientName_exactly100Chars_returnsTrue() {
        String name = "A".repeat(100);
        assertTrue(admission.isValidPatientName(name));
    }

    @Test
    void isValidPatientName_exactly101Chars_returnsFalse() {
        String name = "A".repeat(101);
        assertFalse(admission.isValidPatientName(name));
    }

    // --- isEligibleForPriorityCare tests ---
    @Test
    void isEligibleForPriorityCare_ageOver65NoCondition_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(70, false));
    }

    @Test
    void isEligibleForPriorityCare_ageUnder65WithCondition_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(40, true));
    }

    @Test
    void isEligibleForPriorityCare_ageOver65WithCondition_returnsTrue() {
        assertTrue(admission.isEligibleForPriorityCare(65, true));
    }

    @Test
    void isEligibleForPriorityCare_ageUnder65NoCondition_returnsFalse() {
        assertFalse(admission.isEligibleForPriorityCare(30, false));
    }
}
