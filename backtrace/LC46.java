package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    private int[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        //因为为全排列，递归结束的时候同时收集结果
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //每次都从头开始取数，则i每次从0开始
        for (int i = 0; i < nums.length; i++) {
            //让上一层取到的元素不能重复取
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i] = 0;
        }
    }
}
