package leetcode.evaluate_reverse_polish_notation;

import java.util.Stack;

// 150. Evaluate Reverse Polish Notation https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                nums.add(nums.pop() + nums.pop());
            } else if (token.equals("*")) {
                nums.add(nums.pop() * nums.pop());
            } else if (token.equals("/")) {
                int second = nums.pop();
                int first = nums.pop();
                nums.add(first / second);
            } else if (token.equals("-")) {
                int second = nums.pop();
                int first = nums.pop();
                nums.add(first - second);
            } else {
                nums.add(Integer.parseInt(token));
            }
        }   

        return nums.pop();

    }
}
