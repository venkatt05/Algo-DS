package com.google.hashcode;

import java.util.List;

public class Simulator {

  public static void simulate(
      List<String> pickedup, int clients, List<List<String>> likes, List<List<String>> disLikes) {
    int n = 0;
    for (int j = 0; j < clients; j++) {
      List<String> l1 = likes.get(j);
      List<String> l2 = disLikes.get(j);
      long d = pickedup.stream().filter(s -> l2.contains(s)).count();
      if (d == 0 && pickedup.containsAll(l1)) {
        n++;
      }
    }
    System.out.println("Customer :: " + n);
  }
}
