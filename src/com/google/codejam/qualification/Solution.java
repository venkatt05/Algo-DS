package com.google.codejam.qualification;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int testCases = scan.nextInt();
    int test = 1;
    while (test <= testCases) {
      int b = scan.nextInt();
      int c = scan.nextInt();
      System.out.println("Case #" + test + ":");
      solve(b, c);
      test++;
    }
  }

  public static void solve(int b, int c) {

    char PERIOD = '.';
    char PLUS = '+';
    char PIPE = '|';
    char DASH = '-';
    int totalRows = (b * 2) + 1;
    int totalColumns = (c * 2) + 1;
    for (int i = 0; i < totalRows; i++) {
      for (int j = 0; j < totalColumns; j++) {
        if (j + i < 2) {
          System.out.print(PERIOD);
        } else if (i % 2 != 0) {
          if (j % 2 == 0) System.out.print(PIPE);
          else System.out.print(PERIOD);
        } else {
          if (j % 2 == 0) System.out.print(PLUS);
          else System.out.print(DASH);
        }
      }
      System.out.println();
    }
  }
}
