package com.datastructures.hashtable;

/**
 *
 * Assuming max add operation limited to 10 pow 4
 * Using HashFunction to perform operations in HashTable
 * HashSet implementation with singly linked list
 *
 * */
public class MyHashSet {

  Value[] set = null;

  public MyHashSet() {
    this.set = new Value[100001];
  }

  public MyHashSet(int x) {
    this.set = new Value[x];
  }

  private int hashFunc(int k) {
    return k % this.set.length;
  }

  public void add(int key) {
    Value v = this.set[hashFunc(key)];
    if (v == null) {
      this.set[hashFunc(key)] = new Value(key);
    } else if (v.data != key) {
      Value nextNode = v.next;
      while (nextNode != null) {
        nextNode = nextNode.next;
      }
      nextNode = new Value(key);
    }
  }

  public void remove(int key) {
    Value v = this.set[hashFunc(key)];
    if (v != null) {
      if (v.data == key) {
        this.set[hashFunc(key)] = null;
      } else {
        Value currentNode = v;
        while (currentNode != null) {
          Value nextNode = currentNode.next;
          if (nextNode != null && nextNode.data == key) {
            currentNode.next = nextNode.next;
            nextNode = null;
            break;
          }
          currentNode = nextNode;
        }
      }
    }
  }

  public boolean contains(int key) {
    Value v = this.set[hashFunc(key)];
    boolean isPresent = false;
    if (v == null) {
      return false;
    } else if (v.data == key) {
      isPresent = true;
    } else {
      Value nextNode = v.next;
      while (nextNode != null) {
        if (nextNode.data == key) {
          isPresent = true;
          break;
        }
        nextNode = nextNode.next;
      }
    }
    return isPresent;
  }
}
