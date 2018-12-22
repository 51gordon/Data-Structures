package com.gordon.data.structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    if (node != null) {
      System.out.println(node.e);
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  // NR: non-recursive
  public void preOrderNR() {
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node cur = stack.pop();
      System.out.println(cur.e);
      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }
    }
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.e);
      inOrder(node.right);
    }
  }

  public void postOrder() {
    postOrder(root);
  }

  private void postOrder(Node node) {
    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.println(node.e);
    }
  }

  public void levelOrder() {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      System.out.println(cur.e);
      if (cur.left != null) {
        queue.add(cur.left);
      }
      if (cur.right != null) {
        queue.add(cur.right);
      }
    }
  }

  public E minimum() {
    if (size == 0) {
      throw new IllegalArgumentException("BST is empty!");
    }
    return minimum(root).e;
  }

  private Node minimum(Node node) {
    if (node.left == null) {
      return node;
    }
    return minimum(node.left);
  }

  public E maximum() {
    if (size == 0) {
      throw new IllegalArgumentException("BST is empty!");
    }
    return maximum(root).e;
  }

  private Node maximum(Node node) {
    if (node.right == null) {
      return node;
    }
    return maximum(node.right);
  }

  public E removeMin() {
    E ret = minimum();
    root = removeMin(root);
    return ret;
  }

  private Node removeMin(Node node) {
    if (node.left == null) {
      Node rightNode = node.right;
      node.right = null;
      size--;
      return rightNode;
    }
    node.left = removeMin(node.left);
    return node;
  }

  public E removeMax() {
    E ret = maximum();
    root = removeMax(root);
    return ret;
  }

  private Node removeMax(Node node) {
    if (node.right == null) {
      Node leftNode = node.left;
      node.left = null;
      size--;
      return leftNode;
    }
    node.right = removeMax(node.right);
    return node;
  }

  // Hibbard Deletion
  public void remove(E e) {
    if (root != null) {
      remove(root, e);
    }
  }

  public Node remove(Node node, E e) {
    if (node == null) {
      return null;
    }
    int c = e.compareTo(node.e);
    if (c < 0) {
      node.left = remove(node.left, e);
      return node;
    } else if (c > 0) {
      node.right = remove(node.right, e);
      return node;
    } else { // c == 0
      // 左子树为空
      if (node.left == null) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
      }
      // 右子树为空
      if (node.right == null) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
      }
      // 左右子树都不为空
      // 找到比当前节点大的最小节点，即待删除节点右子树的最小节点
      Node successor = minimum(node.right);
      successor.right = removeMin(node.right);
      successor.left = node.left;
      node.left = node.right = null;
      return successor;
    }
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    generateBSTString(root, 0, res);
    return res.toString();
  }

  private String generateDepthString(int depth) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      res.append("--");
    }
    return res.toString();
  }

  private void generateBSTString(Node node, int depth, StringBuilder res) {
    if (node == null) {
      res.append(generateDepthString(depth)).append("null\n");
      return;
    }
    res.append(generateDepthString(depth)).append(node.e).append("\n");
    generateBSTString(node.left, depth + 1, res);
    generateBSTString(node.right, depth + 1, res);
  }
}
