/**
 * @Description 翻转二叉树
 * @Author mengq
 * @Date 2021/9/8 11:20
 **/
public class Demo9 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        TreeNode node = invertTree(head);
    }

    private static TreeNode invertTree(TreeNode root) {
        func(root);
        return root;
    }

    private static void func(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        func(root.left);
        func(root.right);
    }
}
