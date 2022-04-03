package com.hashtable.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
 * favorite restaurants represented by strings.
 *
 * <p>You need to help them find out their common interest with the least list index sum. If there
 * is a choice tie between answers, output all of them with no order requirement. You could assume
 * there always exists an answer.
 *
 * <p>Example 1:
 *
 * <p>Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill
 * at Torrey Pines","Hungry Hunter Steakhouse","Shogun"] Output: ["Shogun"] Explanation: The only
 * restaurant they both like is "Shogun".
 *
 * <p>Example 2:
 *
 * <p>Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 =
 * ["KFC","Shogun","Burger King"] Output: ["Shogun"] Explanation: The restaurant they both like and
 * have the least index sum is "Shogun" with index sum 1 (0+1).
 *
 * <p>Example 3:
 *
 * <p>Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger
 * King","Tapioca Express","Shogun"] Output: ["KFC","Burger King","Tapioca Express","Shogun"]
 *
 * <p>Example 4:
 *
 * <p>Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger
 * King","Tapioca Express","Shogun"] Output: ["KFC","Burger King","Tapioca Express","Shogun"]
 *
 * <p>Example 5:
 *
 * <p>Input: list1 = ["KFC"], list2 = ["KFC"] Output: ["KFC"]
 *
 * <p>Constraints:
 *
 * <p>1 <= list1.length, list2.length <= 1000 1 <= list1[i].length, list2[i].length <= 30 list1[i]
 * and list2[i] consist of spaces ' ' and English letters. All the stings of list1 are unique. All
 * the stings of list2 are unique.
 */
public class MinIndex {

  public static void main(String[] args) {
    String [] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
    String [] list2 = {"Piatti","The Grill * at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
    var restaurant = findRestaurant(list1, list2);
    System.out.println("Result :: " + Arrays.stream(restaurant).reduce(String::concat));
  }

  public static String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> commons = new HashMap<>();
    for(int i=0;i < list1.length; i++){
      String temp = list1[i];
      for(int j=0;j < list2.length; j++){
        if(list2[j].equals(temp)) {
          commons.put(temp, i + j);
        }
      }
    }
    int minSum = Collections.min(commons.values());
    List<String> result = commons.keySet().stream().filter(v -> commons.get(v)==minSum).collect(Collectors.toList());
    return result.toArray(new String[0]);
  }
}
