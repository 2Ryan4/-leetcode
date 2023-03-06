package stack_queue;

import java.util.Stack;

public class LC232 {

}
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return true;
        }
        return false;
    }

    public void dumpStackIn() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}