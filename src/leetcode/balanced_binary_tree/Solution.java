package leetcode.balanced_binary_tree;

// 110. https://leetcode.com/problems/balanced-binary-tree/description/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root, 0) >= 0;
    }

    public int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftDepth = getDepth(node.left, depth + 1);
        int rightDepth = getDepth(node.right, depth + 1);

        if (leftDepth < 0 || rightDepth < 0) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) >= 2) {
            return -1;
        }

        return Math.max(rightDepth, leftDepth);
    }
}