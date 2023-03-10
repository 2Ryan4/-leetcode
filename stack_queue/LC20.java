package stack_queue;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();//存放的是当前扫描到的左括号所匹配的右括号

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);//当前遍历到的字符
            if (cur == '(') {
                stack.push(')');
            } else if (cur == '[') {
                stack.push(']');
            } else if (cur == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != cur){//针对的是右括号多余和括号不匹配的两种情况
                return false;
            } else {
                stack.pop();//相等就弹出
            }
        }
        return stack.isEmpty();//对应的情况是，遍历完字符串，发现栈不为空，说明还有左括号没有匹配上（左括号多余）
    }
}
