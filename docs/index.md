---
title: Complementary DNA Solution
description: "Translate a DNA sequence into its complement."
---

{% if site.assignment_url -%}

## Assignment

* Link: <{{ site.assignment_url }}>
* Format: IntelliJ Java project

{%- endif %}

## Value

* Basic implementation: 10 points
* Basic unit tests: 5 points
* Extra credit implementation: 5 points
* Extra credit unit tests: 5 points

## Basic task

DNA sequences are generally represented by a string consisting of the characters `A`, `T`, `G`, and `C`, representing the _nucleobases_ adenine, thymine, guanine, and cytosine. _Complementarity_ describes a relationship between two sequences (or one portion of a sequence with another portion of the same sequence), based on an interaction relationship between the nucleobases in each. In very general terms, A and T are complements of each other, as G and C are complements of each other. 

Your task is to implement a method that processes a string, replacing each of the 4 nucleobase characters with its complement.

### Implementation

The `edu.cnm.deepdive.DNA` class defines the method

``` .java
public static String complement(String sequence)
```

Your task is to complete the implementation of `sequence`, according to these specifications:

* Every `A` in `sequence` must be replaced by `T` in the returned value.
* Every `T` in `sequence` must be replaced by `A` in the returned value.

* Every `C` in `sequence` must be replaced by `G` in the returned value.
* Every `G` in `sequence` must be replaced by `C` in the returned value.

### Unit tests

For unit testing credit, use JUnit5 to verify your code with the following inputs and expected outputs.

| `sequence` | Expected value returned by `DNA.complement(sequence)` |
|:-------------:|:-------------:|
| `"ATATGCGC"` | `"TATACGCG"` |
| `"GCCTTTAAAATTTCCG"` | `"CGGAAATTTTAAAGGC"` |
| `"ATCGATCG"` | `"TAGCTAGC"` |
| `"CCCCGGGTTA"` | `"GGGGCCCAAT"` |

In evaluating your implementation, we reserve the right to include additional test cases; code that satisfies the requirements stated above should pass all such additional tests.
 
### Hints

* The method to be completed is `static`. There is no need to create instances of `DNA` (and arguably no benefit in doing so).  

* You may find it useful to create one or more additional `static` methods as "helpers"; the problem can be solved without doing so, however.

* Do not hesitate to declare any constants (`static final` fields) that you feel might simplify or clarify your code.

* The method to be completed includes a `TODO` comments to that effect.

## Extra credit

In the basic problem, all characters in the input string are assumed to be upper-case. In some cases, it can be useful not only to handle lower- or mixed-case input, but to preserve the case of the input, replacing each character with its complement of the same case.

### Implementation

For extra credit, complete the implementation of the overload of `complement` (**do not** change the signature of the method you previously implemented) with the following signature, return type, and modifiers:

``` .java
public static String complement(String sequence, boolean respectCase)
```

When `respectCase` is `true`, this method should make the following replacements:

* Every `A` in `sequence` must be replaced by `T` in the returned value.
* Every `a` in `sequence` must be replaced by `t` in the returned value.
* Every `T` in `sequence` must be replaced by `A` in the returned value.
* Every `t` in `sequence` must be replaced by `a` in the returned value.
* Every `C` in `sequence` must be replaced by `G` in the returned value.
* Every `c` in `sequence` must be replaced by `g` in the returned value.
* Every `G` in `sequence` must be replaced by `C` in the returned value.
* Every `g` in `sequence` must be replaced by `c` in the returned value.

When `respectCase` is `false`, your implementation should simply return an upper-case result, regardless of the case of `input`.

For full credit, you should have as little repeated code as possible between the 2 overloads of `complement`; one way to do this is to have one overloaded method invoke another. Also, an invocation of the `complement(String sequence)` overload should behave exactly the same as an invocation of `complement(String sequence, boolean respectCase)`, where `respectCase` has the value `false`. (Depending on your approach, this may require modification of your implementation from the basic problem.)

### Unit tests

For unit testing extra credit, use JUnit5 to test your implementation with the following test cases:

| `sequence` | `respectCase` | Expected value returned by `DNA.complement(sequence, respectCase)` |
|:-------------:|:-------------:|:-----------:|
| `"AtaTGcgC"` | `true` | `"TatACgcG"` |
| `"GCctTtaAAaTTtcCG"` | `true` | `"CGgaAatTTtAAagGC"` |
| `"ATcgAtcG"` | `true` | `"TAgcTagC"` |
| `"CccCGggTta"` | `true` | `"GggGCccAat"` |
| `"AtaTGcgC"` | `false` | `"TATACGCG"` |
| `"GCctTtaAAaTTtcCG"` | `false` | `"CGGAAATTTTAAAGGC"` |
| `"ATcgAtcG"` | `false` | `"TAGCTAGC"` |
| `"CccCGggTta"` | `false` | `"GGGGCCCAAT"` |

In evaluating your implementation, we reserve the right to include additional test cases; code that satisfies the requirements stated above should pass all such additional tests.

### Hints

* The method to be completed is `static`. There is no need to create instances of `DNA` (and arguably no benefit in doing so).

* You may find it useful to create one or more additional `static` methods as "helpers"; the problem can be solved without doing so, however.

* Do not hesitate to declare any constants (`static final` fields) that you feel might simplify or clarify your code.

* The method to be completed includes a `TODO` comments to that effect.

* In order to minimize repeated code, it is common for the implementation of a method overload to include an invocation of another overload of the same name.

## Solution

### Overview

The basic approach used here is a `switch`, mapping the original characters to their complements. This `switch` is executed in the body of a `for`, iterating over a `char[]` containing all of the characters in the input. As each `char` is mapped, it is appended to a `StringBuilder` instance.

For the extra credit solution, the `for` loop and the `switch` are moved to the `complement(String, boolean)` overload, which is in turn invoked by `complement(String)`. The original case of each `char`, along with the `respectCase` parameter value, are used to control whether the complementary `char` should be transformed back to lowercase before appending to the `StringBuilder`.

### Code

For implementation details, see the source listing: [`edu.cnm.deepdive.DNA`](api/src-html/edu/cnm/deepdive/DNA.html)
