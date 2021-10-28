package com.algorithms.trees.problems;

public class IsMaxHeap {
  boolean isHeap(Node tree) {
    if(tree == null){
      return true;
    }

    Node root = tree;
    Node left = tree.left;
    Node right = tree.right;

    if(left != null && left.data > root.data){
      return false;
    }

    if(right != null && right.data > root.data){
      return false;
    }

    return isHeap(left) && isHeap(right);

  }
}
