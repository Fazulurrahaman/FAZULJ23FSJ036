package edu.disease.asn2;

import java.util.UUID;

/**
* The {@code InfectiousDisease} class represents an infectious disease and extends the {@code Disease} class.
*/
public class InfectiousDisease extends Disease {

   /**
    * Constructs an {@code InfectiousDisease} object with the specified disease ID and name.
    *
    * @param diseaseId The unique identifier for the infectious disease.
    * @param name      The name of the infectious disease.
    */
   public InfectiousDisease(UUID diseaseId, String name) {
       super(diseaseId, name);
   }

   /**
    * Gets examples of infectious diseases.
    *
    * @return An array of example infectious disease names.
    */
   @Override
   public String[] getExamples() {
       return new String[] {
    		   "Common cold",
               "The flu (influenza)",
               "COVID-19",
               "Stomach flu (gastroenteritis)"
       };
   }
}