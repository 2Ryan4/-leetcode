package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC93 {
    private ArrayList<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return result;
    }

    public void backtrack(String s, int startIndex, int pointNum) {
        //递归结束条件：当前.的数量为3，说明已分隔成四段
        if (pointNum == 3) {
            //区间为左闭右闭
            if (isValid(s, startIndex, s.length() -1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                //添加.
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtrack(s, i + 2, pointNum);
                //回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }

    public boolean isValid(String s, int begin, int end) {
        if (begin > end) {
            return false;
        }
        //以0为开头的两位或三位数不合法
        if (s.charAt(begin) == '0' && begin != end) {
            return false;
        }
        int num = 0;
        for (int i = begin; i <= end; i++) {
            //确保字符为合法数字
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            //确保数字在[0,255]之间
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
