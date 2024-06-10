package leetcode.minimum_height_trees;

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        LinkedList<Integer> leaves = new LinkedList<>();
        int[] leaveCounts = new int[n];

        for (int i = 0; i < n; i ++) {
            neighbors.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        for (Map.Entry<Integer, List<Integer>> e : neighbors.entrySet()) {
            leaveCounts[e.getKey()] = e.getValue().size();
            if (leaveCounts[e.getKey()] < 2) {
                leaves.add(e.getKey());
            }
        }

        while (!leaves.isEmpty()) {
            if (n <= 2) {
                break;
            }
            int leaveSize = leaves.size();

            for (int i = 0; i < leaveSize; i++) {
                int leaf = leaves.pollFirst();
                for (int neighbor : neighbors.get(leaf)) {
                    leaveCounts[neighbor]--;
                    if (leaveCounts[neighbor] == 1) {

                        leaves.add(neighbor);
                    }
                }
                n--;
                neighbors.remove(leaf);

            }
        }

        return leaves;
    }
}