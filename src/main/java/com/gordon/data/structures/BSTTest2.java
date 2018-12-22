package com.gordon.data.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSTTest2 {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<Integer>();
    Random random = new Random();
    int n = 1000;
    for (int i = 0; i < n; i++) {
      bst.add(random.nextInt(10000));
    }

    List<Integer> nums = new ArrayList<Integer>();
    while (!bst.isEmpty()) {
      nums.add(bst.removeMin());
    }

    System.out.println(nums);

    for (int i = 1; i < nums.size(); i++) {
      if (nums.get(i - 1) >= nums.get(i)) {
        throw new IllegalArgumentException("Error");
      }
    }

    System.out.println("RemoveMin test completed.");
  }
}
