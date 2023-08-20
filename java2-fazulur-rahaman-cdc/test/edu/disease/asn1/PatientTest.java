package edu.disease.asn1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.models.Exposure;
import edu.disease.asn1.models.Patient;

import java.util.Arrays;
import java.util.UUID;

public class PatientTest {
    private Patient patient;
    private UUID diseaseId;

    @BeforeEach
    public void setUp() {
        // Create a new Patient instance with maximum capacities for diseases and exposures
        patient = new Patient(5, 3);
        
        // Create a sample disease ID for testing
        diseaseId = UUID.randomUUID();
    }

    @Test
    public void testAddDiseaseId() {
        // Add a disease ID to the patient
        patient.addDiseaseId(diseaseId);

        // Check if the disease ID was added correctly
        UUID[] diseaseIds = patient.getDiseaseIds();
        assertEquals(diseaseId, diseaseIds[0]);
    }

    @Test
    public void testAddExposure() {
        // Create a sample exposure for testing
        Exposure exposure = new Exposure(UUID.randomUUID());

        // Add an exposure to the patient
        patient.addExposure(exposure);

        // Check if the exposure was added correctly
        Exposure[] exposures = patient.getExposures();
        assertEquals(exposure, exposures[0]);
    }

    @Test
    public void testConstructorWithInvalidCapacity() {
        // Ensure that an IllegalArgumentException is thrown for non-positive capacities
        assertThrows(IllegalArgumentException.class, () -> new Patient(-1, 3));
        assertThrows(IllegalArgumentException.class, () -> new Patient(5, 0));
    }

    @Test
    public void testHashCodeAndEquals() {
        // Create two patients with the same patientId
        Patient patient1 = new Patient(5, 3);
        patient1.setPatientId(patient.getPatientId());

        // Create another patient with a different patientId
        Patient patient2 = new Patient(5, 3);

        assertTrue(patient.equals(patient1));
        assertFalse(patient.equals(patient2));
        assertEquals(patient.hashCode(), patient1.hashCode());
        assertNotEquals(patient.hashCode(), patient2.hashCode());
    }

    @Test
    public void testToString() {
        // Manually construct the expected string to match the format produced by toString
        String expectedString = "Patient{" +
                "patientId=" + patient.getPatientId() +
                ", firstName='" + patient.getFirstName() + '\'' +
                ", lastName='" + patient.getLastName() + '\'' +
                ", exposures=" + Arrays.toString(patient.getExposures()) +
                ", diseaseIds=" + Arrays.toString(patient.getDiseaseIds()) +
                '}';

        assertEquals(expectedString, patient.toString());
    }

}
