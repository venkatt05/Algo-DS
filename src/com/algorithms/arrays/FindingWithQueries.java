package com.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindingWithQueries {

  public static int[] minInterval(int[][] intervals, int[] queries) {

    int[] res = new int[queries.length];
    Map<Integer, Integer> cache = new HashMap<>();
    int counter = 0;
    int inl = intervals.length;
    int n = queries.length - 1;

    while (n >= 0) {
      var query = queries[n];
      if (cache.get(query) != null) {
        res[counter++] = cache.get(query);
      } else {
        int smallestIndex = -1;
        int smallestDuration = Integer.MAX_VALUE;
        int i = 0;
        while (i < inl) {
          int left = intervals[i][0];
          int right = intervals[i][1];
          if ((left <= query && query <= right) && ((right - left + 1) < smallestDuration)) {
            smallestIndex = i;
            smallestDuration = right - left + 1;
          }
          i++;
        }

        var sd = smallestIndex == -1 ? -1 : smallestDuration;
        res[counter++] = sd;
        cache.put(query, sd);
      }
    }

    return res;
  }

  public static void main(String[] args) {}
}
