package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77 {
    //当前路径存放的元素
    private LinkedList<Integer> path = new LinkedList<>();
    //结果集
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        //for循环代表树的宽度，i <= n - (k - path.size()) + 1做剪枝操作
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            //存放当前元素
            path.add(i);
            //往下递归，代表树的深度
            backTracking(n, k, i + 1);
            //回溯
            path.removeLast();
        }
    }
}
