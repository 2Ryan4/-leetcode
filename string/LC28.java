package string;

public class LC28 {
    public int strStr(String haystack, String needle) {
        int[] next = next(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1;
            }

        }
        return -1;
    }

    public int[] next(String needle) {
        int j = 0;//前缀末尾
        int i;//后缀末尾
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];//回退
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            next[i] = j;
        }
        return next;
    }
}

