package Week_2.test;

import Week_2.challenge.PatientAdmission;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PatientAdmissionTest {
    private PatientAdmission admission;

    @BeforeEach
    void setUp() {
        admission = new PatientAdmission();
    }

    // --- calculateRiskScore exception tests ---
    @Test
    void calculateRiskScore_temperatureBelow30_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(20.0, 40);
        });
    }

    @Test
    void calculateRiskScore_temperatureAbove45_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.calculateRiskScore(46.0, 40);
        });
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

    // --- calculateRiskScore parameterized tests ---
    @ParameterizedTest
    @CsvSource({
            "40.0, 70, 80", // high temp + elderly = 50 + 30
            "38.0, 55, 40", // moderate temp + middle age = 25 + 15
            "36.5, 25, 0",  // normal temp + young = 0 + 0
            "39.5, 30, 50", // boundary high temp + young = 50 + 0
    })
    void calculateRiskScore_variousInputs_returnsCorrectScore(
            double temp, int age, int expectedScore) {
        assertEquals(expectedScore, admission.calculateRiskScore(temp, age));
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

    // --- formatPatientReport tests ---
    // Acceptance Criteria 1
    @Test
    void formatPatientReport_validInputs_formatsStringCorrectly() {
        assertEquals("Patient: John Doe | Score: 75 | Priority: URGENT",
                admission.formatPatientReport("John Doe", 75, "URGENT"));
    }

    // Acceptance Criteria 2
    @Test
    void formatPatientReport_moderatePriority_formatsStringCorrectly() {
        assertEquals("Patient: Jane Smith | Score: 40 | Priority: MODERATE",
                admission.formatPatientReport("Jane Smith", 40, "MODERATE"));
    }

    // Acceptance Criteria 3 (zero score)
    @Test
    void formatPatientReport_zeroScore_formatsStringCorrectly() {
        assertEquals("Patient: Bob | Score: 0 | Priority: ROUTINE",
                admission.formatPatientReport("Bob", 0, "ROUTINE"));
    }

    // Acceptance Criteria 4 (edge case - single letter name)
    @Test
    void formatPatientReport_singleLetterName_formatsStringCorrectly() {
        assertEquals("Patient: A | Score: 20 | Priority: ROUTINE",
                admission.formatPatientReport("A", 20, "ROUTINE"));
    }

    // Acceptance Criteria 5 (edge case - max values)
    @Test
    void formatPatientReport_maxValues_formatsStringCorrectly() {
        assertEquals("Patient: Maximum Length Name String Here | Score: 100 | Priority: URGENT",
                admission.formatPatientReport("Maximum Length Name String Here", 100, "URGENT"));
    }

    // --- formatPatientReport exception tests ---
    @Test
    void formatPatientReport_nullName_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.formatPatientReport(null, 50, "MODERATE");
        });
    }

    @Test
    void formatPatientReport_negativeScore_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.formatPatientReport("John Doe", -5, "ROUTINE");
        });
    }

    @Test
    void formatPatientReport_unknownPriority_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            admission.formatPatientReport("John Doe", 50, "UNKNOWN");
        });
    }
}
