import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/22 16:56
 **/
public class Demo26 {
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int val = root.val;
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.right != null){
                nextEnd = node.right;
                queue.offer(node.right);
                val = node.right.val;
            }
            if(node.left != null){
                nextEnd =  node.left;
                queue.offer(node.left);
                val = node.left.val;
            }
            if(node == curEnd){
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return val;
    }
}
