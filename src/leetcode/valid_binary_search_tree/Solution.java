package leetcode.valid_binary_search_tree;

class Solution {

    // Using long for MAX and MIN value
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        return checkBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean checkBST(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return checkBST(node.left, node.val, min) && checkBST(node.right, max, node.val);
    }

    // Using

    public boolean checkBST(TreeNode node, int max, int min) {
        if (node == null) {
            return true;
        }

        if (node.val < min || node.val > max) {
            return false;
        }

        if (node.left != null && node.left.val >= node.val) {
            return false;
        }

        if (node.right != null && node.right.val <= node.val) {
            return false;
        }

        return checkBST(node.left, node.val - 1, min) && checkBST(node.right, max, node.val + 1);
    }
}
