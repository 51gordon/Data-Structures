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
    System.out.println(bst);
    System.out.println();

    System.out.println("前序遍历：");
    bst.preOrder();

    System.out.println("中序遍历：");
    bst.inOrder();

    System.out.println("后序遍历：");
    bst.postOrder();

    System.out.println("非递归的前序遍历：");
    bst.preOrderNR();

    System.out.println("层序（广度优先）遍历：");
    bst.levelOrder();

    System.out.println("二分搜索树最小值：");
    System.out.println(bst.minimum());

    System.out.println("二分搜索树最大值：");
    System.out.println(bst.maximum());
  }
}
