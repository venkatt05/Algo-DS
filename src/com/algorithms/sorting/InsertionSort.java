package com.algorithms.sorting;

import java.util.Arrays;

/**
 * Used when array is small or most of the elements is sorted
 * Time Complexity - O(n^2)
 * Space Complexity - O(1)
 */
public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = { 1, 2,5,7,34,2341,23};

    System.out.println("Ascending sort :: ");
    sortAscending(arr);
    Arrays.stream(arr).forEach(System.out::println);

    System.out.println("Descending sort :: ");
    sortDescending(arr);
    Arrays.stream(arr).forEach(System.out::println);
  }

  private static void sortAscending(int[] arr){
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;

      while(j>=0 && arr[j] > key){
        arr[j + 1] = arr[j];
        j = j-1;
      }
      arr[j+1] = key;
    }
  }

  private static void sortDescending(int[] arr){
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;

      while(j>=0 && arr[j] < key){
        arr[j + 1] = arr[j];
        j = j-1;
      }
      arr[j+1] = key;
    }
  }
}
