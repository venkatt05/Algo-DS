package com.algorithms.arrays;

/**
 * Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has
 * an element from each array. We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we
 * need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is
 * minimum.
 *
 * <p>Example:
 *
 * <p>Input: ar1[] = {1, 4, 5, 7}; ar2[] = {10, 20, 30, 40}; x = 32 Output: 1 and 30
 *
 * <p>Input: ar1[] = {1, 4, 5, 7}; ar2[] = {10, 20, 30, 40}; x = 50 Output: 7 and 40
 */
public class FindClosest {

  public static void solve(int ar1[], int ar2[], int x) {
    int res1 = 0; // to store the index
    int res2 = 0;
    int l = 0;
    int r = ar2.length;
    int diff = Integer.MAX_VALUE;

    for (int i = 0; i < ar1.length; i++) {
      for (int j = ar2.length - 1; j >= 0; j--) {
        var abs = Math.abs(ar1[i] + ar2[j] - x);
        if (abs > x) continue;
        if (abs < diff) {
          res1 = i;
          res2 = j;
          diff = abs;
        }
      }
    }

    System.out.println(ar1[res1] + " " + ar2[res2]);
  }

  public static void main(String[] args) {
    int ar1[] = {1, 4, 5, 7};
    int ar2[] = {10, 20, 30, 40};
    int x = 50;
    solve(ar1, ar2, x);
  }
}
