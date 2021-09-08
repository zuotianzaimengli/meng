/**
 * @Description 是否是镜像二叉树
 * @Author mengq
 * @Date 2021/9/7 14:18
 **/
public class Demo4 {

    private static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    private static boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right != null || left != null && right == null || left.val != right.val){
            return false;
        }
        if(left == null && right == null){
            return true;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

}
