/**
 * @Description 二叉树深度
 * @Author mengq
 * @Date 2021/9/7 11:02
 **/
public class Demo2 {

    public static void main(String[] args) {

    }
    private static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
