package edu.disease.asn2;

import java.util.UUID;

/**
 * The {@code NonInfectiousDisease} class represents a non-infectious disease and extends the {@code Disease} class.
 */
public class NonInfectiousDisease extends Disease {

    /**
     * Constructs a {@code NonInfectiousDisease} object with the specified disease ID and name.
     *
     * @param diseaseId The unique identifier for the non-infectious disease.
     * @param name      The name of the non-infectious disease.
     */
    public NonInfectiousDisease(UUID diseaseId, String name) {
        super(diseaseId, name);
    }

    /**
     * Gets examples of non-infectious diseases.
     *
     * @return An array of example non-infectious disease names.
     */
    @Override
    public String[] getExamples() {
        return new String[]{
        		"Colour blindness",
                "Heart attack",
                "Diabetes",
                "Hay fever"
        };
    }
}
