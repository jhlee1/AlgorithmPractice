package leetcode.diameter_of_binary_tree;


// 543. https://leetcode.com/problems/diameter-of-binary-tree/description/

class Solution {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return result;
    }

    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftDepth = traverse(node.left);
        int rightDepth = traverse(node.right);

        result = Math.max(result, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}