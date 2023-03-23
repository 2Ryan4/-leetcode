package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216 {
    private LinkedList<Integer> path = new LinkedList<Integer>();//当前路径
    private ArrayList<List<Integer>> result = new ArrayList<>();//结果集
    private boolean flag = false;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return result;
    }

    public void backtrack(int k, int n, int startIndex) {
        //递归结束条件：相加和大于n或路径元素等于k
        if (n < 0 || path.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            n -= i;
            backtrack(k, n, i + 1);
            n += i;
            path.removeLast();
        }
    }
}
