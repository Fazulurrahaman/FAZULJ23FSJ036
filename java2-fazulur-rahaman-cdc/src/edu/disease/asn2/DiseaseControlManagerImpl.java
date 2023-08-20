package edu.disease.asn2;

import java.util.ResourceBundle;
import java.util.UUID;

public class DiseaseControlManagerImpl implements DiseaseControlManager {
    private Disease[] diseases;
    private Patient[] patients;
    private int diseaseCount;
    private int patientCount;
    private int maxDiseases;
    private int maxPatients;
    private ResourceBundle resourceBundle;
    
    /**
     * Constructs a {@code DiseaseControlManagerImpl} with the specified maximum diseases
     * and maximum patients capacity.
     *
     * @param maxDiseases The maximum capacity for diseases.
     * @param maxPatients The maximum capacity for patients.
     * @throws IllegalArgumentException If maxDiseases or maxPatients is non-positive.
     */
    public DiseaseControlManagerImpl(int maxDiseases, int maxPatients) {
    	this.resourceBundle = ResourceBundle.getBundle("messages");
        if (maxDiseases <= 0 || maxPatients <= 0) {
            throw new IllegalArgumentException(resourceBundle.getString("unable.initiatethearray"));
        }
        this.maxDiseases = maxDiseases;
        this.maxPatients = maxPatients;
        this.diseases = new Disease[maxDiseases];
        this.patients = new Patient[maxPatients];
        this.diseaseCount = 0;
        this.patientCount = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Disease addDisease(String name, boolean infectious, UUID diseaseId) {
        if (diseaseCount >= maxDiseases) {
            throw new IllegalStateException(resourceBundle.getString("unable.disease"));
        }
        
        Disease disease;
        if (infectious) {
            disease = new InfectiousDisease(diseaseId, name);
        } else {
            disease = new NonInfectiousDisease(diseaseId, name);
        }
        
        diseases[diseaseCount++] = disease;
        return disease;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Disease getDisease(UUID diseaseId) {
        for (Disease disease : diseases) {
            if (disease != null && disease.getDiseaseId().equals(diseaseId)) {
                return disease;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures, UUID patientId) {
        if (patientCount >= maxPatients) {
            throw new IllegalStateException(resourceBundle.getString("unable.patient"));
        }

        Patient patient = new Patient(maxDiseases, maxExposures);
        patient.setPatientId(patientId);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        
        patients[patientCount++] = patient;
        return patient;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Patient getPatient(UUID patientId) {
        for (Patient patient : patients) {
            if (patient != null && patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
        Patient patient = getPatient(patientId);
        if (patient == null) {
            throw new IllegalArgumentException(resourceBundle.getString("patient.notfound"));
           }

        Disease disease = getDisease(diseaseId);
        if (disease == null) {
            throw new IllegalArgumentException(resourceBundle.getString("disease.notfound"));
        }

        patient.addDiseaseId(diseaseId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addExposureToPatient(UUID patientId, Exposure exposure) {
        Patient patient = getPatient(patientId);
        if (patient == null) {
            throw new IllegalArgumentException(resourceBundle.getString("patient.notfound"));
        }

        patient.addExposure(exposure);
    }
}
