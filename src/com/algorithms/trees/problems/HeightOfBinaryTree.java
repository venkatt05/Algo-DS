package com.algorithms.trees.problems;

public class HeightOfBinaryTree {

  public static int height(Node node){
    if(node == null ) {
      return 0;
    }
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  public static void main(String[] args) {
    Node root = new Node(12);
    System.out.println(height(root));
  }
}
