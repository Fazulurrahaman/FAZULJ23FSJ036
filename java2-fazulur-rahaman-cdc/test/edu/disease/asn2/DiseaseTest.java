package edu.disease.asn2;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DiseaseTest {

   
    @Test
    public void testInfectiousDiseaseExamples() {
        // Create an InfectiousDisease instance
        UUID diseaseId = UUID.randomUUID();
        InfectiousDisease infectiousDisease = new InfectiousDisease(diseaseId, "Test Infectious Disease");

        // Test getExamples method
        assertArrayEquals(
            new String[] {
                "Common cold",
                "The flu (influenza)",
                "COVID-19",
                "Stomach flu (gastroenteritis)"
            },
            infectiousDisease.getExamples()
        );
    }

    @Test
    public void testNonInfectiousDiseaseExamples() {
        // Create a NonInfectiousDisease instance
        UUID diseaseId = UUID.randomUUID();
        NonInfectiousDisease nonInfectiousDisease = new NonInfectiousDisease(diseaseId, "Test Non-Infectious Disease");

        // Test getExamples method
        assertArrayEquals(
            new String[] {
                "Colour blindness",
                "Heart attack",
                "Diabetes",
                "Hay fever"
            },
            nonInfectiousDisease.getExamples()
        );
    }
}

