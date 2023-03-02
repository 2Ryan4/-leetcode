package string;

public class LC541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            //定义结束指针的位置，如果剩下字符个数小于k个，则剩余字符全部反转
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start <= end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }


}
