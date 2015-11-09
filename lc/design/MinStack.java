package lc.design;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if(min.empty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if(min.peek() == val) {
            min.pop();
        } 
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
