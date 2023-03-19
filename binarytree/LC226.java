package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        swap(node);
        invert(node.left);
        invert(node.right);
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
