package leetcode.add_two_numbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultRoot = new ListNode(-1);
        ListNode temp = resultRoot;
        int carryOver = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;

            carryOver = 0;

            if (sum > 9) {
                sum -= 10;
                carryOver++;
            }

            temp.next = new ListNode(sum);
            temp = temp.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val + carryOver;

            carryOver = 0;

            if (sum > 9) {
                sum -= 10;
                carryOver++;
            }

            temp.next = new ListNode(sum);
            temp = temp.next;

            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + carryOver;

            carryOver = 0;

            if (sum > 9) {
                sum -= 10;
                carryOver++;
            }

            temp.next = new ListNode(sum);
            temp = temp.next;

            l2 = l2.next;
        }

        if (carryOver > 0 ) {
            temp.next = new ListNode(carryOver);
        }

        return resultRoot.next;
    }

    /**
     * this part should be removed on the submission
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
