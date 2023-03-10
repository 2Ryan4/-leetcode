package stack_queue;

import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();//存放数字的栈

        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            //遇到数字压入栈中，遇到符号弹出两个数字，得到运算结果，再压入栈中，遍历完后，栈中只剩一个数字即为最终结果
            if (tokens[i].equals("*")) {
                Integer num1 = nums.pop();
                Integer num2 = nums.pop();
                Integer result = num2 * num1;
                nums.push(result);
            } else if (tokens[i].equals("/")) {
                Integer num1 = nums.pop();
                Integer num2 = nums.pop();
                Integer result = num2 / num1;
                nums.push(result);
            } else if (tokens[i].equals("+")) {
                Integer num1 = nums.pop();
                Integer num2 = nums.pop();
                Integer result = num2 + num1;
                nums.push(result);
            } else if (tokens[i].equals("-")) {
                Integer num1 = nums.pop();
                Integer num2 = nums.pop();
                Integer result = num2 - num1;
                nums.push(result);
            } else {
                nums.push(Integer.parseInt(tokens[i]));
            }
        }

        return nums.pop();

    }
}
