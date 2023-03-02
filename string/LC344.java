package string;

public class LC344 {
    public void reverseString(char[] s) {
        //定义左右指针用于交换元素
        int left = 0;
        int right = s.length - 1;
        char temp;

        while (left <= right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }
}
