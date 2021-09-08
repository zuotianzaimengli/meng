/**
 * @Description 合并两个二叉树
 * @Author mengq
 * @Date 2021/9/7 17:09
 **/
public class Demo8 {
    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        int v1 = root1 == null ? 0 : root1.val;
        int v2 = root2 == null ? 0 : root2.val;
        TreeNode head = new TreeNode(v1 + v2);
        head.left = mergeTrees(root1 == null ? null : root1.left,root2 == null ? null : root2.left);
        head.right = mergeTrees(root1 == null ? null : root1.right,root2 == null ? null : root2.right);
        return head;
    }
}
