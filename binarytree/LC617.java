package binarytree;

public class LC617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //因为对每个节点的操作相同，采用递归方式

        //递归结束条件，一棵树遇到空节点，将另一个树相应的结点补上去
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        //单层递归的操作逻辑：合并两颗树的当前结点
        //直接修改t1的结构，使其成为合并二叉树
        //遍历顺序为前序遍历
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
