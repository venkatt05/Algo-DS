package com.algorithms;

import java.util.ArrayList;

public class SubSequences {

  static int findSubSequences(String s){
    int n = s.length();
    int res = 0;
    for (int i = 0; i < n; i += 1) {
      int l = i - 1;
      while (l >= 0) {
        if (s.charAt(l) == s.charAt(i)) break;
        l -= 1;
      }
      int r = i + 1;
      while (r < n) {
        if (s.charAt(r) == s.charAt(i)) break;
        r += 1;
      }

      System.out.println(r +" :: " + i + " :: " + l);
      System.out.println((r - i) * (i - l));
      res += (r - i) * (i - l);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(findSubSequences("ABA"));
  }
}
