package edu.disease.asn1.models;

import java.util.UUID;

/**
 * The {@code Disease} class represents a disease with properties including a unique disease ID
 * and a name.
 */
public class Disease {
    private UUID diseaseId;
    private String name;

    /**
     * Constructs a {@code Disease} object with the specified disease ID and name.
     *
     * @param diseaseId The UUID representing the unique disease ID.
     * @param name      The name of the disease.
     */
    public Disease(UUID diseaseId, String name) {
        this.diseaseId = diseaseId;
        this.name = name;
    }

    /**
     * Gets the disease ID of this {@code Disease} object.
     *
     * @return The UUID representing the disease ID.
     */
    public UUID getDiseaseId() {
        return diseaseId;
    }

    /**
     * Sets the disease ID of this {@code Disease} object.
     *
     * @param diseaseId The UUID representing the disease ID to set.
     */
    public void setDiseaseId(UUID diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * Gets the name of this {@code Disease} object.
     *
     * @return The name of the disease.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this {@code Disease} object.
     *
     * @param name The name of the disease to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Computes a hash code for this {@code Disease} object based on its diseaseId.
     *
     * @return The computed hash code.
     */
    @Override
    public int hashCode() {
        return diseaseId.hashCode();
    }

    /**
     * Indicates whether some other object is equal to this {@code Disease} object.
     * Two diseases are considered equal if they have the same diseaseId.
     *
     * @param o The object to compare for equality.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        return diseaseId.equals(disease.diseaseId);
    }

    /**
     * Returns a string representation of this {@code Disease} object, including
     * all of its properties.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Disease{" +
                "diseaseId=" + diseaseId +
                ", name='" + name + '\'' +
                '}';
    }
}
