import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description bst中序转普通二叉树
 * @Author mengq
 * @Date 2021/9/7 14:42
 **/
public class Demo5 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        TreeNode node = increasingBST(root);
    }


    private static TreeNode increasingBST(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        increasingBST(root,queue);
        TreeNode temp = new TreeNode(-1);
        TreeNode tail = temp;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            node.left = null;
            node.right = null;
            tail.right = node;
            tail = tail.right;
        }
        return temp.right;
    }

    private static void increasingBST(TreeNode root, Queue<TreeNode> queue){
        if(root == null){
            return;
        }
        increasingBST(root.left,queue);
        queue.offer(root);
        increasingBST(root.right,queue);
    }
}
