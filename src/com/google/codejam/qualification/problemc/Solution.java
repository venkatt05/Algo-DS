package com.google.codejam.qualification.problemc;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int testCases = scan.nextInt();
    int test = 1;
    while (test <= testCases) {
      int dices = scan.nextInt();
      int[] diceArray = new int[dices];
      for (int i = 0; i < dices; i++) {
        diceArray[i] = scan.nextInt();
      }
      System.out.println("Case #" + test + ": " + solve(diceArray));
      test++;
    }
  }

  public static int solve(int[] diceArray) {
    if (diceArray.length == 1) {
      return 1;
    }
    int length = 0;
    Arrays.sort(diceArray);
    for (int i = 0; i < diceArray.length; i++) {
      if (diceArray[i] > length) {
        length++;
      }
    }
    return length;
  }
}

//10 10 7 6 7 4 4 5 7 4
//4 4 4 5 6 7 7 7 10 10
//1 2 3 4 5 6 7   8 9


