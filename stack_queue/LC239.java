package stack_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int windows = len - k + 1;//窗口数
        int[] results = new int[windows];//结果数组
        MyDeque myDeque = new MyDeque();
        for (int i = 0; i < k; i++) {
            myDeque.offer(nums[i]);
        }
        int num = 0;
        results[num++] = myDeque.peek();
        for (int i = k; i < len; i++) {
            myDeque.poll(nums[i - k]);
            myDeque.offer(nums[i]);
            results[num++] = myDeque.peek();
        }
        return results;
    }

}
class MyDeque {
    Deque<Integer> deque = new LinkedList<Integer>();

    //该类实现在保证元素相对位置正确的情况下，里面的元素单调递减，保证队头元素为当前窗口的最大值

    public void offer(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.pollLast();//如果添加元素比队尾元素大，则弹出队尾元素，知道队尾元素大于等于添加元素，保证其单调性
        }
        deque.offerLast(val);
    }

    public void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
            //如果要弹出元素与队头元素相等，则弹出，如果不相等，说明之前在添加元素时，该元素已经被弹出
        }
    }

    public int peek() {
        return deque.peek();
    }
}