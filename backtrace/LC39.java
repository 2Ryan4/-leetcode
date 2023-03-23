package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC39 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int startIndex) {
        //终止条件：相加和大于等于目标值
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝操作：第一种剪枝还是遍历完整轮for循环；第二种剪枝在排好序的基础上不用遍历完整轮for循环,在for判断加上target>=candidate[i]
            if (target < candidates[i]) {
                continue;
            }
            //回溯
            path.add(candidates[i]);
            target -= candidates[i];
            backtrack(candidates, target, i);
            path.removeLast();
            target += candidates[i];
        }
    }
}
