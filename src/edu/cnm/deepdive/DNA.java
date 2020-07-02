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

/**
 * This class includes the {@link #complement(String)} and {@link #complement(String, boolean)}
 * methods, both of which implement a simple string converter that replaces the nucleobase symbols
 * (<code>A</code>,<code>T</code>, <code>C</code>, and <code>G</code>), with their respective
 * complements (<code>T</code>,<code>A</code>, <code>G</code>, and <code>C</code>), in a string
 * representing a DNA sequence/subsequence. Implementation of these methods is included in the
 * practical exam materials of the Deep Dive Coding Java + Android Bootcamp.
 */
public class DNA {

  private DNA() {
    // NOTE: There is NO need to do anything with this constructor! The methods you will implement
    // in this class is static; thus, there is no need to create instances of this class.
  }

  /* BASIC PROBLEM */

  /**
   * Converts and returns the DNA complement of <code>sequence</code>, with each nucleobase symbol
   * (character) replaced by its complementary symbol.
   *
   * @param sequence DNA sequence.
   * @return complementary DNA sequence.
   */
  public static String complement(String sequence) {
    return complement(sequence, false);
  }

  /* EXTRA CREDIT PROBLEM */

  /**
   * Converts and returns the DNA complement of <code>sequence</code>, with each nucleobase symbol
   * (character) replaced by its complementary symbol. Optionally, the case of <code>sequence</code>
   * is respected, according <code>respectCase</code>: if <code>true</code>, each character in
   * <code>sequence</code> is replaced by its complement of the same case; if <code>false</code>,
   * all characters in the returned value will be upper-case, regardless of the case of the
   * characters in <code>sequence</code>.
   *
   * @param sequence DNA sequence.
   * @param respectCase flag controlling the case of the returned value.
   * @return complementary DNA sequence.
   */
  public static String complement(String sequence, boolean respectCase) {
    StringBuilder builder = new StringBuilder();
    char[] chars = sequence.toCharArray();
    for (char c : chars) {
      boolean isLowerCase = respectCase && Character.isLowerCase(c);
      c = Character.toUpperCase(c);
      char complement;
      switch (c) {
        case 'A':
          complement = 'T';
          break;
        case 'C':
          complement = 'G';
          break;
        case 'G':
          complement = 'C';
          break;
        case 'T':
          complement = 'A';
          break;
        default:
          complement = c;
          break;
      }
      if (isLowerCase) {
        complement = Character.toLowerCase(complement);
      }
      builder.append(complement);
    }
    return builder.toString();
  }

}
