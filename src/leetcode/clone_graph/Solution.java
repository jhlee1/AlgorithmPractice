package leetcode.clone_graph;

import java.util.HashMap;
import java.util.Map;

// 133. Clone Graph https://leetcode.com/problems/clone-graph/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }

        Map<Integer, Node> nodes = new HashMap<>();
        Node result = new Node(node.val);

        nodes.put(result.val, result);
        traverse(node, result, nodes);

        return result;
    }

    public void traverse(Node node, Node result, Map<Integer, Node> copiedNodes) {
        if (!result.neighbors.isEmpty()) {
            return;
        }
        for (Node n : node.neighbors) {
            copiedNodes.putIfAbsent(n.val, new Node(n.val));
            result.neighbors.add(copiedNodes.get(n.val));
            if (n.val > node.val) {
                traverse(n, copiedNodes.get(n.val), copiedNodes);
            }
        }
    }


}
