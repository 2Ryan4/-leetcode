package binarytree;

import java.util.ArrayList;
import java.util.List;

public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        travelPath(root, path, results);
        return results;

    }

    public void travelPath(TreeNode node, List<Integer> path, List<String> results) {
        path.add(node.val);

        //递归结束条件遇到叶子结点，则当前为一条完整路径
        if (node.left == null && node.right == null) {
            //拼接路径使其成为字符串
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < path.size() - 1; i++) {
                stringBuffer.append(path.get(i) + "->");
            }
            stringBuffer.append(path.get(path.size() - 1));
            //将该条路径放入结果集中
            String s = stringBuffer.toString();
            results.add(s);
        }

        //往左右递归
        if (node.left != null) {
            travelPath(node.left, path, results);
            path.remove(path.size() - 1);//回溯
        }

        if (node.right != null) {
            travelPath(node.right, path, results);
            path.remove(path.size() - 1);//回溯
        }

    }
}
