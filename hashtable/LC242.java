package hashtable;

import java.util.ArrayList;
import java.util.HashMap;

public class LC242 {
    public static void main(String[] args) {
        LC242 lc242 = new LC242();
        boolean result = lc242.isAnagram("adc", "acd");
        System.out.println(result);
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] word1 = s.toCharArray();
        char[] word2 = t.toCharArray();
        HashMap<Character, Integer> ss = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tt = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length; i++) {
            Integer temp1 = ss.get(word1[i]);
            Integer temp2 = tt.get(word2[i]);
            if (temp1 == null) {
                ss.put(word1[i], 1);
            } else {
                ss.put(word1[i], temp1 + 1);
            }
            if (temp2 == null) {
                tt.put(word2[i], 1);
            } else {
                tt.put(word2[i], temp2 + 1);
            }
        }
        for (int i = 0; i < ss.size(); i++) {
            if (!(ss.get(word1[i]).equals(tt.get(word1[i])))) {
                return false;
            }
        }
        return true;


    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //因为仅包含小写字母，记录每个字符出现次数的数组大小为26
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //a的索引是0，z的索引是25
            int index = s.charAt(i) - 'a';
            record[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            record[index]--;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;

    }


}
