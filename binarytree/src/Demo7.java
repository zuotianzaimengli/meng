import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树最后一层最左节点
 * @Author mengq
 * @Date 2021/9/7 16:40
 **/
public class Demo7 {

    private static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode res = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res = node;
            if(node.right != null){
                queue.offer(node.right);
            }
            if(node.left != null){
                queue.offer(node.left);
            }
        }
        return res.val;
    }


}
