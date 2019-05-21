package leetcode.merge_two_sorted_lists;


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode currentPoint = result;
        while(l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                currentPoint.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                currentPoint.next = new ListNode(l1.val);
                l1 = l1.next;
            }

            currentPoint = currentPoint.next;
        }

        while (l1 != null) {
            currentPoint.next = new ListNode(l1.val);
            currentPoint = currentPoint.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            currentPoint.next = new ListNode(l2.val);
            currentPoint = currentPoint.next;
            l2 = l2.next;
        }

        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}