package string;

import java.util.Stack;

public class LC459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null && "".equals(s)) {
            return false;
        }
        int length = s.length();
        int[] next = new int[length];
        next[0] = 0;
        int j = 0;
        int i;
        for (i = 1; i < length; i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        if (next[length -1] > 0 && length % (length - next[length - 1]) == 0) {
            return true;
        }
        return false;


    }
}
