package leetcode.implement_queue_using_stacks;

import java.util.Stack;


// 232. https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {

    Stack<Integer> left;
    Stack<Integer> right;

    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();

    }

    public void push(int x) {
        left.add(x);
    }

    public int pop() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.add(left.pop());
            }
        }

        return right.pop();
    }

    public int peek() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.add(left.pop());
            }
        }

        return right.peek();

    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */