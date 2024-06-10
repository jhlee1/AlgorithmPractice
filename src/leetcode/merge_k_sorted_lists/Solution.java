package leetcode.merge_k_sorted_lists;

// 23. Merge k sorted Lists https://leetcode.com/problems/merge-k-sorted-lists/description/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return divideAndMerge(lists, 0, lists.length - 1);
    }

    public ListNode divideAndMerge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        return mergeNodes(divideAndMerge(lists, left, (left + right) / 2), divideAndMerge(lists, (left + right) / 2 + 1, right));
    }

    public ListNode mergeNodes(ListNode left, ListNode right) {
        ListNode result;
        ListNode resultCurrent;
        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.val <= right.val) {
            result = left;
            resultCurrent = result;
            left = left.next;
        } else {
            result = right;
            resultCurrent = result;
            right = right.next;
        }

        while (left != null && right != null) {
            if (left.val <= right.val) {
                resultCurrent.next = left;
                left = left.next;
            } else {
                resultCurrent.next = right;
                right = right.next;
            }
            resultCurrent = resultCurrent.next;
        }

        if (left != null) {
            resultCurrent.next = left;
        }

        if (right != null) {
            resultCurrent.next = right;
        }

        return result;
    }
}