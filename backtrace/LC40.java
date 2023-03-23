package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    private boolean[] used;//表示是否使用过
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int startIndex) {
        //递归终止条件：相加和等于target
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //树层去重和剪枝操作
            if (i > 0 && candidates[i] == candidates[i -1] && used[i -1] == false || target < candidates[i]) {
                continue;
            }
            target -= candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            backtrack(candidates, target, i + 1);
            path.removeLast();
            used[i] = false;
            target += candidates[i];
        }
    }
}
