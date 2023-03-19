package binarytree;

public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = solution(nums, 0, nums.length - 1);
        return root;
    }

    //返回参数为结点，传入参数为数组和区间
    public TreeNode solution(int[] nums, int left, int right) {
        //递归结束条件：分隔的数组为空数组
        if (left > right) {
            return null;
        }

        //确定中间位置为根节点
        int mid = left + ((right - left) / 2);
        TreeNode node = new TreeNode(nums[mid]);

        //构建左右子树
        node.left = solution(nums, left, mid - 1);
        node.right = solution(nums, mid + 1, right);

        return node;
    }
}
