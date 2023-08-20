package edu.disease.asn2;


import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * The {@code Patient} class represents a patient with properties including a unique patient ID,
 * first name, last name, disease IDs, and exposures.
 */
public class Patient {
    private UUID patientId;
    private String firstName;
    private String lastName;
    private Exposure[] exposures;
    private UUID[] diseaseIds;

    /**
     * Constructs a {@code Patient} object with the specified maximum capacity for disease IDs
     * and exposures.
     *
     * @param maxDiseases   The maximum capacity for disease IDs.
     * @param maxExposures  The maximum capacity for exposures.
     * @throws IllegalArgumentException If maxDiseases or maxExposures is non-positive.
     */
    public Patient(int maxDiseases, int maxExposures) {
    	ResourceBundle bundle = ResourceBundle.getBundle("messages");
        if (maxDiseases <= 0 || maxExposures <= 0) {
            throw new IllegalArgumentException(bundle.getString("unable.initiatethearray"));
        }

        // Initialize the diseaseIds array with the specified size
        this.diseaseIds = new UUID[maxDiseases];

        // Initialize the exposures array with the specified size
        this.exposures = new Exposure[maxExposures];

        // Generate a unique patientId (you can use UUID.randomUUID() for this)
        this.patientId = UUID.randomUUID();
    }

    /**
     * Adds a disease ID to the diseaseIds array.
     *
     * @param diseaseId The UUID representing the disease ID to add.
     * @throws IndexOutOfBoundsException If the diseaseIds array is full.
     */
    public void addDiseaseId(UUID diseaseId) {
        for (int i = 0; i < diseaseIds.length; i++) {
            if (diseaseIds[i] == null) {
                diseaseIds[i] = diseaseId;
                return; // Successfully added
            }
        }
        throw new IndexOutOfBoundsException("The diseaseIds array is full.");
    }

    /**
     * Adds an exposure to the exposures array.
     *
     * @param exposure The exposure to add.
     * @throws IndexOutOfBoundsException If the exposures array is full.
     */
    public void addExposure(Exposure exposure) {
        for (int i = 0; i < exposures.length; i++) {
            if (exposures[i] == null) {
                exposures[i] = exposure;
                return; // Successfully added
            }
        }
        throw new IndexOutOfBoundsException("The exposures array has reached its maximum capacity.");
    }

    // Getter and setter methods for firstName, lastName, patientId, and other properties...

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Exposure[] getExposures() {
        return exposures;
    }

    public void setExposures(Exposure[] exposures) {
        this.exposures = exposures;
    }

    public UUID[] getDiseaseIds() {
        return diseaseIds;
    }

    public void setDiseaseIds(UUID[] diseaseIds) {
        this.diseaseIds = diseaseIds;
    }

    /**
     * Computes a hash code for this {@code Patient} object based on its patientId.
     *
     * @return The computed hash code.
     */
    @Override
    public int hashCode() {
        return patientId.hashCode();
    }

    /**
     * Indicates whether some other object is equal to this {@code Patient} object.
     * Two patients are considered equal if they have the same patientId.
     *
     * @param o The object to compare for equality.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        return patientId.equals(patient.patientId);
    }

    /**
     * Returns a string representation of this {@code Patient} object, including
     * all of its properties.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", exposures=" + Arrays.toString(exposures) +
                ", diseaseIds=" + Arrays.toString(diseaseIds) +
                '}';
    }
    
    /**
     * Compares this patient to another patient for sorting.
     * Patients are sorted by last name (case-insensitive), and then by first name (case-insensitive).
     *
     * @param otherPatient The other patient to compare to.
     * @return A negative integer, zero, or a positive integer as this patient is less than, equal to,
     *         or greater than the other patient.
     */
    public int compareTo(Patient otherPatient) {
        // First, compare last names in a case-insensitive manner
        int lastNameComparison = this.lastName.compareToIgnoreCase(otherPatient.lastName);

        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // If last names are the same (ignoring case), compare first names in a case-insensitive manner
        return this.firstName.compareToIgnoreCase(otherPatient.firstName);
    }


}