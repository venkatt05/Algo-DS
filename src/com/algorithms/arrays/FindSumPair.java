package com.algorithms.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a function that takes a list of numbers and a target number, and then returns the number of
 * unique pairs that add up to the target number.
 *
 * <p>[X, Y] and [Y, X] are considered the same pair, and not unique.
 *
 * <p>Examples Example 1: Input: [1, 1, 2, 45, 46, 46], target = 47 Output: 2
 */
public class FindSumPair {

  static int getPair(List<Integer> nums, int target) {
    Set<Integer> nu = new HashSet<>(nums);

    var count = nums.stream().map(v -> target - v).filter(nu::contains).map(v -> {
      int elementToRemove = target - v;
      nu.remove(v);
      nu.remove(elementToRemove);
      return 1;
    }).count();

    return (int)count;
  }

  public static void main(String[] args) {
    int target = 47;
    System.out.println(getPair(Arrays.asList(1, 1), target));
  }
}
