package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> nodes = new LinkedList<>();//存放结点的队列
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();//存放当层的结果
            int size = nodes.size();//表示队列弹出结点的数量，即每层的结点数量
            TreeNode cur = null;
            while (size-- > 0) {
                cur = nodes.poll();
                list1.add(cur.val);
                if (cur.left != null) {
                    nodes.offer(cur.left);
                }//将当前结点的左孩子加入队列
                if (cur.right != null) {
                    nodes.offer(cur.right);
                }
            }
            list.add(list1);
        }
        return list;

    }
}
