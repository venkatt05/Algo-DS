package com.algorithms.arrays;

public class InputTest {

  public static void main(String args[]) {
    String a = "a3b4cd7e";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < a.length(); i++) {

      if (61 > (int) a.charAt(i)) {
        if (i != 0) {
          int t = Integer.parseInt("" + a.charAt(i)) - 1;
          while (t != 0) {
            sb.append(a.charAt(i - 1));
            t--;
          }
        }
        continue;
      }
      sb.append(a.charAt(i));
    }

    System.out.println(sb);
  }
}
