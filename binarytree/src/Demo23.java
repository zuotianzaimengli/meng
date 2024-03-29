import java.util.*;

/**
 * @Description
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/13 15:46
 **/
public class Demo23 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        queue.offer(root);
        List<Integer> curList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                nextEnd = node.left;
                queue.offer(node.left);
            }
            if(node.right != null){
                nextEnd = node.right;
                queue.offer(node.right);
            }
            curList.add(node.val);
            if(node == curEnd){
                res.add(0,curList);
                curList = new ArrayList<>();
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return res;
    }
}
