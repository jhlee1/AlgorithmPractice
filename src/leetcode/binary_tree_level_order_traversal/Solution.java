package leetcode.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

// 102. Binary tree level order traversal https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, 0, result);

        return result;
    }

    public void dfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        while (result.size() <= depth) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(node.val);

        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }
}
