package edu.disease.asn2;

import java.util.UUID;

/**
 * The {@code DiseaseControlManager} interface defines methods for managing diseases, patients, and exposures
 * within an application.
 */
public interface DiseaseControlManager {

	/**
     * Adds a new disease to the application.
     *
     * @param name        A name for the disease.
     * @param infectious  True if the disease is infectious; false otherwise.
     * @param diseaseId   The unique identifier for the disease.
     * @return The added disease, or null if not found.
     */
    Disease addDisease(String name, boolean infectious, UUID diseaseId);
    
    /**
     * Retrieves a disease by its unique identifier.
     *
     * @param diseaseId  The unique identifier for the disease.
     * @return The retrieved disease, or null if not found.
     */
    Disease getDisease(UUID diseaseId);
    
    /**
     * Adds a new patient to the application.
     *
     * @param firstName     The first name of the patient.
     * @param lastName      The last name of the patient.
     * @param maxDiseases   The maximum capacity for disease IDs for the patient.
     * @param maxExposures  The maximum capacity for exposures for the patient.
     * @param patientId     The unique identifier for the patient.
     * @return The added patient, or null if not found.
     */
    Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures, UUID patientId);
    
    /**
     * Retrieves a patient by their unique identifier.
     *
     * @param patientId  The unique identifier for the patient.
     * @return The retrieved patient, or null if not found.
     */
    Patient getPatient(UUID patientId);
    
    /**
     * Adds a disease to a patient.
     *
     * @param patientId  The unique identifier for the patient.
     * @param diseaseId  The unique identifier for the disease.
     */
    void addDiseaseToPatient(UUID patientId, UUID diseaseId);
    

    /**
     * Adds an Exposure instance to a patient.
     *
     * @param patientId  The unique identifier for the patient.
     * @param exposure   The Exposure instance to add to the patient.
     */
    void addExposureToPatient(UUID patientId, Exposure exposure);
}
