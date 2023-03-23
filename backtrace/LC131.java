package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC131 {
    private LinkedList<String> path = new LinkedList<>();
    private ArrayList<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    public void backtrack(String s, int startIndex) {
        //终止条件：分隔到字符串末尾
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //单层逻辑
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                //左闭右开
                String substring = s.substring(startIndex, i + 1);
                path.add(substring);
            } else {
                //不是回文字符串就跳过本次操作
                continue;
            }
            backtrack(s, i + 1);
            path.removeLast();

        }
    }

    //用来判断是否为回文字符串
    public boolean isPalindrome(String s, int begin, int end) {
        for (int i = begin, j = end;i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
