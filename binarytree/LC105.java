package binarytree;

import java.util.HashMap;

public class LC105 {
    public HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode findNode(int[] preOrder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        //左闭右开
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        //取前序数组的第一个元素为中间结点
        TreeNode root = new TreeNode(preOrder[preBegin]);

        //获取中间结点在中序数组的位置
        Integer rootIndex = map.get(root.val);

        //获取左子树结点数量
        int lenOfLeft = rootIndex - inBegin;

        root.left = findNode(preOrder, preBegin + 1, preBegin + lenOfLeft + 1, inorder,  inBegin, inBegin + lenOfLeft);
        root.right = findNode(preOrder, preBegin + lenOfLeft + 1, preEnd, inorder,  rootIndex + 1, inEnd);
        return root;
    }
}
