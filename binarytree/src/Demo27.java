/**
 * @Description 二叉树最小深度
 * @Author mengq
 * @Date 2021/10/25 15:29
 **/
public class Demo27 {

    private static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        }
        if(root.left != null && root.right == null){
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
}
