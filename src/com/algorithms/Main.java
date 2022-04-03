package com.algorithms;

public class Main {

  public static void main(String[] args) {
    // {index,child1,child2,parent}
    int[] node0 = {0, 0, 0, 0};
    int[] node1 = {10, 3, 8, 0};
    int[] node2 = {3, 2, 5, 10};
    int[] node3 = {2, 0, 0, 3};
    int[] node4 = {5, 0, 0, 3};
    int[] node5 = {8, 0, 0, 10};
    int[][] nodes = {node0, node1, node2, node3, node4, node5};

    System.out.println(getNode(5, nodes)[0]);
  }

  public static int[] getNode(int index, int[][] nodes) {
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i][0] == index) {
        return (nodes[i]);
      }

    }
    return new int[12];
  }
}
