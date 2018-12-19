package com.gordon.data.structures;

public class BST<E extends Comparable<E>> {
  private class Node {
    private E e;
    public Node left, right;

    public Node(E e) {
      this.e = e;
      left = null;
      right = null;
    }
  }

  private Node root;
  private int size;

  public BST() {
    root = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(E e) {
    root = add(root, e);
  }

  // 向以node为根的二分搜索树中插入元素e，递归算法
  // 返回插入新节点后二分搜索树的根
  private Node add(Node node, E e) {
    if (node == null) {
      size++;
      return new Node(e);
    }
    if (e.compareTo(node.e) < 0) {
      node.left = add(node.left, e);
    } else if (e.compareTo(node.e) > 0) {
      node.right = add(node.right, e); // e.compareTo(node.e) > 0
    }
    return node;
  }

  public boolean contains(E e) {
    return contains(root, e);
  }

  private boolean contains(Node node, E e) {
    if (node == null) {
      return false;
    }
    int res = e.compareTo(node.e);
    if (res == 0) {
      return true;
    } else if (res < 0) {
      return contains(node.left, e);
    } else {
      return contains(node.right, e);
    }
  }
}
