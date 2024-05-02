package leetcode.min_stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> original;
    Stack<Integer> mins;
    public MinStack() {
        original = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int val) {
        original.push(val);

        if (mins.isEmpty() || mins.peek() >= val) {
            mins.push(val);
        }

    }

    public void pop() {
        int num = original.pop();
        if (!mins.isEmpty() && mins.peek() == num) {
            mins.pop();
        }

    }

    public int top() {
        return original.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */