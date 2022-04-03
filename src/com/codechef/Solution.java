package com.codechef;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int testCases = scan.nextInt();
    while (testCases > 0) {
      int n = scan.nextInt();
      String str = scan.next();
      System.out.println(solve(str, n));
      testCases--;
    }
  }

  public static int solve(String s, int n) {

    int[] count = new int[2];
    for (int j = 0; j < n; j++) {
      if (s.charAt(j) == '1') {
        count[1]++;
      } else {
        count[0]++;
      }
    }

    char[] arr = s.toCharArray();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n - 1; i++) {
      char prev = arr[i];
      int o = count[1];
      int z = count[0];
      for (int j = i + 1; j < n; j++) {
        if (prev == arr[j]) {
          if (arr[j] == '1' && z > 0) {
            prev = '0';
            z--;
          } else if (o > 0) {
            prev = '1';
            o--;
          } else {
            max = Math.max(max, j);
            break;
          }
        } else {
          prev = arr[j];
        }
        max = Math.max(max, j);
      }
    }
    return max;
  }
}
