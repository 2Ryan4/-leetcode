package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        prefixOrder(root, list);
        return list;
    }

    public void prefixOrder(TreeNode node, List list) {//确定递归的参数和返回值
        if (node == null) {
            return;
        }//递归的终止条件：当前结点为空
        list.add(node.val);//把当前结点的值放入集合
        prefixOrder(node.left, list);//遍历左子树
        prefixOrder(node.right, list);//遍历右子树
    }

    public List<Integer> solution(TreeNode root) {//使用迭代法进行前序遍历
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node = stack.pop();//将栈的元素弹出
            list.add(node.val);//将结果放入集合中
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            //因为处理完中间结点，要处理左节点再处理右节点，因为栈先进后出，所以先把右节点压入栈中

        }
        return list;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}