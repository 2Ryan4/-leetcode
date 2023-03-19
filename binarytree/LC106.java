package binarytree;

import java.util.HashMap;

public class LC106 {
    public HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            //记录中序数组数值的对应位置
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postOrder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            //左闭右开
            return null;
        }
        //后序数组最后一个元素为中间结点
        TreeNode root = new TreeNode(postOrder[postEnd - 1]);

        //获取中间结点在中序数组的位置
        Integer index = map.get(root.val);

        //在中序数组中，中间结点的左边为左子树，右边为右子树
        int lenOfLeft = index - inBegin;

        root.left = findNode(inorder, inBegin, index, postOrder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, index + 1, inEnd, postOrder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
