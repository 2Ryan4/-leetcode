package stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;

    }
}
