package leetcode.lowest_common_ancestor_of_a_binary_tree;

// 236. Lowest common ancestor of a binary tree    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode fromLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode fromRight = lowestCommonAncestor(root.right, p, q);

        if (fromLeft != null && fromRight != null) {
            return root;
        } else if (fromLeft != null) {
            return fromLeft;
        } else if (fromRight != null) {
            return fromRight;
        } else {
            return null;
        }

    }
}
