package com.algorithms.arrays;

import java.util.Arrays;
import java.util.List;

public class StringSort {

  static int solve(char[] arr) {
    int n = arr.length;

    // two arrays will keep the count
    // for number of 0s' and 1s' to be
    // flipped while traversing from
    // left to right and right to
    // left respectively
    int flipsFromLeft[] = new int[n];
    int flipsFromRight[] = new int[n];

    // Fill flipsFromLeft[]
    int flips = 0;
    int hflips = 0;
    for(char c: arr){
      if(c =='H') hflips++;
    }

    for (int i = 0; i < n && hflips > 0; i++) {
      if (arr[i] != 'H') flips++;
      if(i == n && arr[i] == 'H') flips++;
      flipsFromLeft[i] = flips;
    }

    // Fill flipsFromRight[]
    flips = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (arr[i] == 'T') flips++;

      flipsFromRight[i] = flips;
    }

    // initialize minFlip to highest int value. If sum
    // of leftflip and rightFlip is smaller than minflips,
    // then update minFlips
    int minFlips = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      if (flipsFromLeft[i - 1] + flipsFromRight[i] < minFlips) {
        minFlips = flipsFromLeft[i - 1] + flipsFromRight[i];
      }
    }

    return minFlips;
  }

  public static void main(String[] args) {
    System.out.println("Min filps required :: " + solve(new char[] {'H', 'H', 'T', 'H', 'T', 'T'}));
  }
}
