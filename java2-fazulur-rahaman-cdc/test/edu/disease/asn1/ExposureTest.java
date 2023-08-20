package edu.disease.asn1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.disease.asn1.models.Exposure;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ExposureTest {
    private UUID patientId;
    private LocalDateTime dateTime;
    private String exposureType;
    private Exposure exposure;

    @BeforeEach
    public void setUp() {
        patientId = UUID.randomUUID();
        dateTime = LocalDateTime.now();
        exposureType = "D";
        exposure = new Exposure(patientId);
    }

    @Test
    public void testGetPatientId() {
        assertEquals(patientId, exposure.getPatientId());
    }

    @Test
    public void testSetPatientId() {
        UUID newPatientId = UUID.randomUUID();
        exposure.setPatientId(newPatientId);
        assertEquals(newPatientId, exposure.getPatientId());
    }

    @Test
    public void testGetDateTime() {
        assertNull(exposure.getDateTime()); // Initially should be null
        exposure.setDateTime(dateTime);
        assertEquals(dateTime, exposure.getDateTime());
    }

    @Test
    public void testSetDateTime() {
        exposure.setDateTime(dateTime);
        assertEquals(dateTime, exposure.getDateTime());
    }

    @Test
    public void testGetExposureType() {
        assertNull(exposure.getExposureType()); // Initially should be null
        exposure.setExposureType(exposureType);
        assertEquals(exposureType, exposure.getExposureType());
    }

    @Test
    public void testSetExposureTypeValid() {
        exposure.setExposureType(exposureType);
        assertEquals(exposureType, exposure.getExposureType());
    }

    @Test
    public void testSetExposureTypeInvalid() {
        // Test for an invalid exposure type, it should throw an exception
        assertThrows(IllegalArgumentException.class, () -> exposure.setExposureType("Invalid"));
    }

    @Test
    public void testHashCode() {
        exposure.setDateTime(dateTime);
        int expectedHashCode = Objects.hash(patientId, dateTime);
        assertEquals(expectedHashCode, exposure.hashCode());
    }


    @Test
    public void testEquals() {
        Exposure exposure1 = new Exposure(patientId);
        Exposure exposure2 = new Exposure(patientId);
        exposure1.setDateTime(dateTime);
        exposure2.setDateTime(dateTime);
        assertTrue(exposure1.equals(exposure2));
    }

    @Test
    public void testNotEquals() {
        Exposure exposure1 = new Exposure(UUID.randomUUID());
        Exposure exposure2 = new Exposure(UUID.randomUUID());
        exposure1.setDateTime(dateTime);
        exposure2.setDateTime(dateTime);
        assertFalse(exposure1.equals(exposure2));
    }

    @Test
    public void testToString() {
        String expectedString = "Exposure{patientId=" + patientId + ", dateTime=null}";
        assertEquals(expectedString, exposure.toString());
    }
}
