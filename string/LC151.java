package string;

public class LC151 {
    public String reverseWords(String s) {
        StringBuffer sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();

    }

    //删除字符串中多余的空格
    public StringBuffer removeSpace(String s) {
        StringBuffer sb = new StringBuffer();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        while (start <= end) {
            char temp = s.charAt(start);
            if (temp != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(temp);
            }
            start++;
        }
        return sb;
    }

    //反转整个字符串
    public void reverseString(StringBuffer sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //反转单词的字母
    public void reverseEachWord(StringBuffer sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
