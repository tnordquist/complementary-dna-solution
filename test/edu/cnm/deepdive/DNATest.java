/*
 *  Copyright 2020 Deep Dive Coding/CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
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