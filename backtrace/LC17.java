package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC17 {
    private String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private ArrayList<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null && digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0);
        return result;
    }

    StringBuffer path = new StringBuffer();
    public void backtrack(String digits, int num) {
        //结束条件：遍历完所有数字
        if (num == digits.length()) {
            result.add(path.toString());
            return;
        }

        String s = letterMap[digits.charAt(num) - '0'];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtrack(digits, num + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


}
