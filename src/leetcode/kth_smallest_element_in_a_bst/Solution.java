package leetcode.kth_smallest_element_in_a_bst;


import java.util.LinkedList;

// 230. Kth Smallest element in a BST https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return preOrder(root, new LinkedList<>(), k);
    }

    public int preOrder(TreeNode node, LinkedList<Integer> sortedNums, int k) {
        if (sortedNums.size() == k) {
            return sortedNums.pollLast();
        }

        if (node == null) {
            return -1;
        }

        int fromLeft = preOrder(node.left, sortedNums, k);
        sortedNums.add(node.val);
        int fromRight = preOrder(node.right, sortedNums, k);


        return fromLeft >= 0 ? fromLeft : fromRight;
    }
}
