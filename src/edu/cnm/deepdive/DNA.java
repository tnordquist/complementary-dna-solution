package edu.cnm.deepdive;

/**
 * This class implements a simple string converter that replaces the nucleobase symbols
 * (<code>A</code>,<code>T</code>, <code>C</code>, and <code>G</code>), with their respective
 * complements (<code>T</code>,<code>A</code>, <code>G</code>, and <code>C</code>), in a string
 * representing a DNA sequence/subsequence.
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
