package com.gordon.data.structures;

public class BSTTest {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<Integer>();
    int[] nums = {5, 3, 6, 8, 4, 2};
    for (int num : nums) {
      bst.add(num);
    }
    /////////////////
    //      5      //
    //    /   \    //
    //   3     6   //
    //  / \     \  //
    // 2   4     8 //
    /////////////////
    bst.preOrder();

    System.out.println();
    System.out.println(bst);

    System.out.println("中序遍历");
    bst.inOrder();

    System.out.println("后序遍历");
    bst.postOrder();
  }
}
