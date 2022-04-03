package com.google.codejam.qualification.problemb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int testCases = scan.nextInt();
    int test = 1;
    while (test <= testCases) {

      int[] printer1 = new int[4];
      for (int i = 0; i < printer1.length; i++) {
        printer1[i] = scan.nextInt();
      }

      int[] printer2 = new int[4];
      for (int i = 0; i < printer2.length; i++) {
        printer2[i] = scan.nextInt();
      }

      int[] printer3 = new int[4];
      for (int i = 0; i < printer3.length; i++) {
        printer3[i] = scan.nextInt();
      }

      System.out.println("Case #" + test + ": " + solve(printer1, printer2, printer3));
      test++;
    }
  }

  public static String solve(int[] a, int[] b, int[] c) {

    int target = 1_000_000;

    int[] mins = new int[4];
    int k = 0;
    for (int i = 0; i < a.length; i++) {
      mins[i] = Math.min(a[i], Math.min(b[i], c[i]));
      k += mins[i];
    }

    if (k < target) {
      return "IMPOSSIBLE";
    }

    if (k > target) {
      int t = k - target;
      for (int i = 0; i < mins.length; i++) {
        if (t > 0) {
          int l = mins[i] - t;
          if (l >= 0) {
            mins[i] = l;
            break;
          } else {
            t = t - mins[i];
            mins[i] = 0;
          }
        } else {
          break;
        }
      }
    }

    return Arrays.stream(mins).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
