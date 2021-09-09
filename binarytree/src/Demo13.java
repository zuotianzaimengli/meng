/**
 * @Description
 * @Author mengq
 * @Date 2021/9/9 14:27
 **/
public class Demo13 {

    private static boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return isUnivalTree(root,root.val);
    }

    private static boolean isUnivalTree(TreeNode root,int val){
        if(root == null){
            return true;
        }
        return root.val == val && isUnivalTree(root.left,val) && isUnivalTree(root.right,val);
    }
}
