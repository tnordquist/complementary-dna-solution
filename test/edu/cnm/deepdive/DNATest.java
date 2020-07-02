package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class DNATest {

  @DisplayName("DNA.complement(String)")
  @ParameterizedTest(name = "[{index}] sequence = {0}, expected = {1}")
  @CsvFileSource(resources = "sequences-upper.csv")
  void complement(String sequence, String expected) {
    assertEquals(expected, DNA.complement(sequence));
  }

  @DisplayName("DNA.complement(String) & DNA.complement(String, false)")
  @ParameterizedTest(name = "[{index}] sequence = {0}, expected = {1}")
  @CsvFileSource(resources = "sequences-mixed-disrespect.csv")
  void complementDisrespectCase(String sequence, String expected) {
    assertAll(
        () -> assertEquals(expected, DNA.complement(sequence)),
        () -> assertEquals(expected, DNA.complement(sequence, false))
    );
  }

  @DisplayName("DNA.Complement(String, true)")
  @ParameterizedTest(name = "[{index}] sequence = {0}, expected = {1}")
  @CsvFileSource(resources = "sequences-mixed-respect.csv")
  void complementRespectCase(String sequence, String expected) {
    assertEquals(expected, DNA.complement(sequence, true));
  }

}