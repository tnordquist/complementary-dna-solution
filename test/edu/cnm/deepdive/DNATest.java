package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class DNATest {

  @ParameterizedTest
  @CsvFileSource(resources = "/sequences_upper.csv")
  void complement(String sequence, String expected) {
    assertEquals(expected, DNA.complement(sequence));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/sequences_mixed_disrespect.csv")
  void complementDisrespectCase(String sequence, String expected) {
    assertAll(
        () -> assertEquals(expected, DNA.complement(sequence)),
        () -> assertEquals(expected, DNA.complement(sequence, false))
    );
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/sequences_mixed_respect.csv")
  void complementRespectCase(String sequence, String expected) {
    assertEquals(expected, DNA.complement(sequence, true));
  }

}