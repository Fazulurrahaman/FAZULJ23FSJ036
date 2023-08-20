package edu.disease.asn2;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UUID;


/**
 * The {@code Exposure} class represents information about a potential exposure
 * to a disease or infection for a patient. It stores details such as the
 * patient's ID, the date and time of exposure, and the type of exposure.
 * 
 * This class is designed to encapsulate exposure-related data and provides
 * methods to access and manipulate this information.
 */
public class Exposure {
	
    private UUID patientId;
	
	private LocalDateTime dateTime;
	
	private String exposureType;

    /**
     * Constructs an {@code Exposure} object with the specified patient ID.
     * 
     * @param patientId The unique identifier of the patient associated with this exposure.
     */
    public Exposure(UUID patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the patient ID associated with this exposure.
     * 
     * @return The UUID representing the patient ID.
     */
    public UUID getPatientId() {
        return patientId;
    }

    /**
     * Sets the patient ID associated with this exposure.
     * 
     * @param patientId The UUID representing the patient ID to set.
     */
    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the date and time of the exposure.
     * 
     * @return The LocalDateTime representing the date and time of exposure.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the exposure.
     * 
     * @param dateTime The LocalDateTime representing the date and time of exposure.
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the type of exposure (e.g., "D" for direct, "I" for indirect).
     * 
     * @return The type of exposure as a string.
     */
    public String getExposureType() {
        return exposureType;
    }

    /**
     * Sets the type of exposure (e.g., "D" for direct, "I" for indirect).
     * 
     * @param exposureType The type of exposure to set.
     * @throws IllegalArgumentException If the provided exposure type is invalid.
     */
    public void setExposureType(String exposureType) {
        ResourceBundle resoureBundle = ResourceBundle.getBundle("messages");

        if (exposureType.equals("D") || exposureType.equals("I")) {
            this.exposureType = exposureType;
        } else {
            throw new IllegalArgumentException(resoureBundle.getString("invalid.exposuretype"));
        }
    }

    /**
     * Computes a hash code for this {@code Exposure} object based on its patient ID
     * and date and time of exposure.
     * 
     * @return The computed hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(patientId, dateTime);
    }

    /**
     * Indicates whether some other object is equal to this {@code Exposure} object.
     * Two exposures are considered equal if they have the same patient ID and date
     * and time of exposure.
     * 
     * @param o The object to compare for equality.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exposure exposure = (Exposure) o;

        return Objects.equals(patientId, exposure.patientId) &&
               Objects.equals(dateTime, exposure.dateTime);
    }

    /**
     * Returns a string representation of this {@code Exposure} object, including
     * its patient ID and date and time of exposure.
     * 
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Exposure{" +
                "patientId=" + patientId +
                ", dateTime=" + dateTime +
                '}';
    }
}


