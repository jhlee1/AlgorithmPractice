package leetcode.invert_binary_tree;


// 226. https://leetcode.com/problems/invert-binary-tree/description/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;

        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}