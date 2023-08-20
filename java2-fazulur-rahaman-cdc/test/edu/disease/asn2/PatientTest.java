package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    @Test
    public void testCompareTo() {
        // Create a list of patients with different last and first names
        Patient patient1 = new Patient(1, 1);
        patient1.setLastName("Doe");
        patient1.setFirstName("John");

        Patient patient2 = new Patient(1, 1);
        patient2.setLastName("Smith");
        patient2.setFirstName("Alice");

        Patient patient3 = new Patient(1, 1);
        patient3.setLastName("Doe");
        patient3.setFirstName("Jane");

        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        // Sort the list of patients using a custom comparator
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.compareTo(p2);
            }
        });

        // Check if the patients are sorted correctly
        assertEquals(patient3, patients.get(0)); 
        assertEquals(patient1, patients.get(1)); 
        assertEquals(patient2, patients.get(2)); 
    }
}
