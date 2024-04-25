package leetcode.reverse_linked_list;


// 206. https://leetcode.com/problems/reverse-linked-list/

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head.next;
        ListNode nextNode = null;
        ListNode prevNode = head;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        head.next = null;

        return prevNode;
    }
}