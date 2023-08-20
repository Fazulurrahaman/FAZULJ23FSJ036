package edu.disease.asn2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DiseaseControlManagerImplTest {

    private DiseaseControlManagerImpl manager;

    @BeforeEach
    void setUp() {
        manager = new DiseaseControlManagerImpl(10, 10);
    }

    @Test
    void addDiseaseShouldAddDiseaseToManager() {
        Disease disease = manager.addDisease("Flu", true, UUID.randomUUID());
        assertNotNull(disease);
    }

    @Test
    void addDiseaseShouldThrowExceptionWhenMaxDiseasesReached() {
        // Fill up the manager with diseases
        for (int i = 0; i < 10; i++) {
            manager.addDisease("Disease " + i, true, UUID.randomUUID());
        }

        assertThrows(IllegalStateException.class, () -> manager.addDisease("Overflow Disease", false, UUID.randomUUID()));
    }

    @Test
    void getDiseaseShouldReturnDiseaseWithMatchingId() {
        UUID diseaseId = UUID.randomUUID();
        manager.addDisease("Flu", true, diseaseId);
        Disease disease = manager.getDisease(diseaseId);
        assertNotNull(disease);
    }

    @Test
    void getDiseaseShouldReturnNullWhenNotFound() {
        assertNull(manager.getDisease(UUID.randomUUID()));
    }

    @Test
    void addPatientShouldAddPatientToManager() {
        Patient patient = manager.addPatient("John", "Doe", 5, 3, UUID.randomUUID());
        assertNotNull(patient);
    }

    @Test
    void addPatientShouldThrowExceptionWhenMaxPatientsReached() {
        // Fill up the manager with patients
        for (int i = 0; i < 10; i++) {
            manager.addPatient("John", "Doe", 5, 3, UUID.randomUUID());
        }

        assertThrows(IllegalStateException.class, () -> manager.addPatient("Overflow", "Patient", 5, 3, UUID.randomUUID()));
    }

    @Test
    void getPatientShouldReturnPatientWithMatchingId() {
        UUID patientId = UUID.randomUUID();
        manager.addPatient("John", "Doe", 5, 3, patientId);
        Patient patient = manager.getPatient(patientId);
        assertNotNull(patient);
    }

    @Test
    void getPatientShouldReturnNullWhenNotFound() {
        assertNull(manager.getPatient(UUID.randomUUID()));
    }

    @Test
    void addDiseaseToPatientShouldAddDiseaseToPatient() {
        UUID patientId = UUID.randomUUID();
        UUID diseaseId = UUID.randomUUID();

        manager.addPatient("John", "Doe", 5, 3, patientId);
        manager.addDisease("Flu", true, diseaseId);

        manager.addDiseaseToPatient(patientId, diseaseId);

        Patient patient = manager.getPatient(patientId);
        assertEquals(diseaseId, patient.getDiseaseIds()[0]);
    }

    @Test
    void addDiseaseToPatientShouldThrowExceptionWhenPatientNotFound() {
        UUID diseaseId = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> manager.addDiseaseToPatient(UUID.randomUUID(), diseaseId));
    }

    @Test
    void addDiseaseToPatientShouldThrowExceptionWhenDiseaseNotFound() {
        UUID patientId = UUID.randomUUID();

        manager.addPatient("John", "Doe", 5, 3, patientId);

        assertThrows(IllegalArgumentException.class, () -> manager.addDiseaseToPatient(patientId, UUID.randomUUID()));
    }

    @Test
    void addExposureToPatientShouldAddExposureToPatient() {
        UUID patientId = UUID.randomUUID();
        Exposure exposure = new Exposure(patientId);

        manager.addPatient("John", "Doe", 5, 3, patientId);
        manager.addExposureToPatient(patientId, exposure);

        Patient patient = manager.getPatient(patientId);
        assertEquals(exposure, patient.getExposures()[0]);
    }

    @Test
    void addExposureToPatientShouldThrowExceptionWhenPatientNotFound() {
        Exposure exposure = new Exposure(UUID.randomUUID());

        assertThrows(IllegalArgumentException.class, () -> manager.addExposureToPatient(UUID.randomUUID(), exposure));
    }
}
