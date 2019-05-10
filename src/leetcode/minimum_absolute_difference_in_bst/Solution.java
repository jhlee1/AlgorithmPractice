package leetcode.minimum_absolute_difference_in_bst;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        if (root.left != null && root.right != null) {
            return Math.min(getMinDiff(root), Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));
        } else if (root.left != null) {
            return Math.min(getMinDiff(root), getMinimumDifference(root.left));
        } else if (root.right != null) {
            return Math.min(getMinDiff(root), getMinimumDifference(root.right));
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private int getMinDiff(TreeNode node) {
        int rightMin = Integer.MAX_VALUE;
        int leftMax = Integer.MAX_VALUE;
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }

            leftMax = node.val - left.val;
        }

        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }

            rightMin = right.val - node.val;
        }

        return Math.min(leftMax, rightMin);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
