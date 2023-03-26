package greed;

public class LC738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int index = s.length();//要变为9的下标初始位置
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                index = i;
                chars[i - 1]--;
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = '9';
        }

        String s1 = String.valueOf(chars);
        int result = Integer.parseInt(s1);
        return result;
    }
}
