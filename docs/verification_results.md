# Programming Project 3 — Verification Results

**Course:** CS 2430 – Discrete Structures  
**Project:** The Knapsack Problem  
**Role:** Verification Lead  
**Date tested:** November 15, 2026  
**Status:** **Testing performed — fixes needed before final approval**

## 1. Purpose

I tested our Java program to check that it follows the Knapsack Problem requirements. I checked the three greedy strategies, brute-force results, weight limits, totals, and important edge cases. I also checked the extra rules described in our Change Order comments.

The files were tested as received. **I did not change the team's implementation.** The uploaded file `Main (1).java` was copied under the required filename `Main.java` only so Java could compile it.

**Important limitation:** The instructor's actual Canvas Change Request was not provided. The special-rule tests below use the rules described in `GreedyStrategies.java`, so the expected results involving those rules need to be confirmed against that request.

## 2. Test Summary

| Status | Number of checks |
|---|---:|
| PASS | 15 |
| FAIL | 11 |
| REVIEW / NEEDS CONFIRMATION | 4 |
| **Total** | **30** |

**Environment:** OpenJDK 21; `javac *.java` and `java Main` both succeeded when the main file was named `Main.java`.

### Checks that passed

The program compiled and ran. The 13 stored experiment records matched the values in `Main.java`; the three greedy strategies produced experiment selections without duplicates; the brute-force method returned three different subsets in descending rating order; and the comparison summary agreed with the results returned by the algorithms. The edge-case tests also passed for a combination weighing exactly 700 kg, an item weighing more than 700 kg, an item that could not fit, an empty selection at zero capacity, and items with equal ratings.

### Checks that failed

The main problems were in the Change Order functionality and the weights and optimal results affected by it:

- **T04 and T05:** Lightest First and Ratio First each report **664 kg**, but the selected experiments include Seed Viability and Yeast Fermentation, so the stated 7 kg reduction should give **657 kg**.
- **T08:** The three brute-force results do not apply the discount. Rank 1 reports **664 kg** rather than **657 kg** for that selected subset.
- **T11 and T24:** An independent exhaustive calculation found a valid **58-point subset weighing 695 kg** after the discount, but the program's best result is **57 points at a reported 664 kg**.
- **T20:** Seed Viability (7 kg) together with Yeast Fermentation (27 kg) is reported as **34 kg** rather than the **27 kg** adjusted total specified by the code comments.
- **T21, T23 and T25:** The program can select Cosmic Rays (Secondary Band) without Primary Band. With a 10 kg capacity, both a greedy strategy and brute force accept the secondary band alone.
- **T22:** The program does not prevent the combined selection of Solar Flares, Solar Power and Sun Spots, even though the team's code comments prohibit that triple.
- **T26:** The program accepts **4,652** subsets at capacity 700, but the independent calculation accepts **3,338** once the described special rules are applied.

## 3. Program Output (Before Fixes)

| Strategy | Reported weight | Reported rating | Compared with the program's brute-force result |
|---|---:|---:|---|
| Highest Rating First | 690 kg | 40 | Did not match |
| Lightest First | 664 kg | 57 | Matched |
| Best Rating-to-Weight Ratio | 664 kg | 57 | Matched |
| Brute Force – best | 664 kg | 57 | Baseline |

All four reported weights are at or below 700 kg. However, these are **outputs from the current implementation**, not approved final results under the intended Change Order rules.

The current brute-force method reports these three ratings: **57, 56, 56**. All three returned subsets are distinct. The two 56-point subsets are tied in rating, so their order is not important.

## 4. Independent Cross-Check

The independent reference script enumerated all **2^13 = 8,192** subsets. It does not call the team's Java algorithms. It applies the rules described in `GreedyStrategies.java` using the actual experiment names.

| Comparison | Total subsets evaluated | Valid subsets | Best rating | Weight of best |
|---|---:|---:|---:|---:|
| No Change Order rules | 8,192 | 4,652 | 57 | 664 kg |
| Special rules from Java comments | 8,192 | 3,338 | **58** | **695 kg** |

The independent provisional optimal combination is:

1. Cloud Patterns — 36 kg, rating 5
2. Binary Stars — 203 kg, rating 8
3. Relativity — 104 kg, rating 8
4. Seed Viability — 7 kg, rating 4
5. Mice Tumors — 65 kg, rating 8
6. Micrometeorites — 170 kg, rating 9
7. Cosmic Rays (Primary Band) — 80 kg, rating 7
8. Cosmic Rays (Secondary Band) — 10 kg, rating 5
9. Yeast Fermentation — 27 kg, rating 4

The raw weight is **702 kg**. The special 7 kg reduction makes its effective weight **695 kg**, within the 700 kg limit. Its total rating is **58**.

**This expected result is provisional:** it depends on the Change Order rules being exactly as described by the code comments.

## 5. Main Issue and How to Fix It

In `Main.java`, the experiment names are descriptive strings, such as `"Seed Viability"` and `"Cosmic Rays (Secondary Band)"`. But `GreedyStrategies.java` checks them against strings such as `"6"`, `"12"`, `"11"`, and `"11a"`. Since the strings never match, the Change Order checks and weight discount are not applied to the loaded experiments.

**Recommended correction for the Implementation Lead:**

1. Make the experiment identifiers consistent in `Main.java` and `GreedyStrategies.java`. The team could use the actual names in the comparisons or add stable experiment IDs.
2. Make sure the `passesChangeOrder()` and `getFinalWeight()` rules work for real items, not just synthetic items with numeric names.
3. Rerun all algorithms and confirm that brute force includes valid subsets that become feasible after the 7 kg discount.
4. Run the verification tests again after the changes and update this report with the new results.

`BruteForce.java` calls the same helper methods, so the helper bugs also affect the brute-force search. `Comparison.java` reflects those incorrect algorithm results even though its own summary formatting and match/difference logic behave as coded.

## 6. Extra Credit and Review Items

`DynamicProgramming.java` contains pseudocode comments but no working dynamic-programming method. This appears to satisfy the **non-extra-credit pseudocode requirement** of the provided assignment; it does **not** qualify for the optional dynamic-programming implementation credit.

The original assignment lists **12 experiments (4,096 subsets)**. The current code has **13 experiments (8,192 subsets)** because of the additional Cosmic Rays secondary band. This may be required by the Week 3 Change Request, but the team should confirm it against the official request.

## 7. Evidence

- `program_output_original.txt` — original program output (`java Main`)
- `verification_test_log.txt` — all 30 checks and pass/fail results
- `reference_oracle_output.txt` — independent unrestricted and Change Order calculations
- `KnapsackVerificationTests.java` — automated Java verification tests
- `reference_oracle.py` — independent enumeration used for cross-checking

## 8. Conclusion

The program runs successfully and several important parts work, including the basic greedy methods, the overall brute-force structure, the comparison output, and the edge cases. However, **I cannot mark the project as fully verified yet** because the Change Order rules are not applied correctly to the current experiment names. These issues cause incorrect reported weights and can cause the program to miss a better valid combination. After the Implementation Lead makes the corrections, I will rerun the same tests and record the final results.
