package com.google.hashcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  static List<List<String>> likes = new ArrayList<>();
  static List<List<String>> disLikes = new ArrayList<>();
  static Set<String> allIngredients = new HashSet<>();
  static List<String> pickedIngredient = new ArrayList<>();
  static List<String> notPickedIngredient = new ArrayList<>();
  static Map<String, Long> lcount = new HashMap<>();
  static Map<String, Long> dcount = new HashMap<>();

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int potentialClients = in.nextInt();
      getInput(potentialClients, in);
      //      System.out.println(allIngredients.size());
      for (String i : allIngredients) {
        long disLikedCount = getNumberOfClientWhoDislikesTheIngredient(i);
        long likedCount = getNumberOfClientWhoLikesTheIngredient(i);
        dcount.put(i, disLikedCount);
        lcount.put(i, likedCount);
      }
      simulate(pickedIngredient, potentialClients, likes, disLikes);
    }
    System.out.println(
        pickedIngredient.size() + " " + pickedIngredient.stream().collect(Collectors.joining(" ")));
  }

  public static long getNumberOfClientWhoDislikesTheIngredient(String ing) {
    return disLikes.stream().filter(li -> li.contains(ing)).count();
  }

  public static long getNumberOfClientWhoLikesTheIngredient(String ing) {
    return likes.stream().filter(li -> li.contains(ing)).count();
  }

  public static void getInput(int clients, Scanner in) {
    int nFactor = clients * 2;
    for (int t = 1; t <= nFactor; t++) {
      int next = in.nextInt();
      List<String> ingredientList = new ArrayList<>();
      while (next > 0) {
        String ingredient = in.next();
        ingredientList.add(ingredient);
        allIngredients.add(ingredient);
        next--;
      }
      if (t % 2 == 0) {
        disLikes.add(ingredientList);
      } else {
        likes.add(ingredientList);
      }
    }
  }

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
