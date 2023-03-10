package stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
}
class MyStack {
    Queue<Integer> queue1 =  new LinkedList<>();
    Queue<Integer> queue2 =  new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue2.offer(x);//先放入辅助队列
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());//将主队列的元素加入到辅助队列中
        }
        Queue<Integer> temp;
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;//交换队列


    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}