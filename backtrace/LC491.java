package backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC491 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        //收集所有符合条件(元素数量大于等于2，且单调递增)的节点
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        //结束条件：起始位置在数组末尾之后
        //如果放在收集结果前，则会缺少加入符合条件的数组最末尾元素的情况
        if (startIndex == nums.length) {
            return;
        }
        //用来检验当前元素在本层是否被使用过
        int[] used = new int[201];
        //单层操作
        for (int i = startIndex; i < nums.length; i++) {
            //当前元素大于等于path的末尾元素才被收集
            if ((!path.isEmpty() && nums[i] < path.getLast()) || used[nums[i] + 100] == 1) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();

        }

    }
}
