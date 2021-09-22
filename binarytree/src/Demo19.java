import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 二叉树最大宽度
 * @Author mengq
 * @Date 2021/9/18 16:07
 **/
public class Demo19 {



    /**
     *      1
     *     / \
     *    3   2
     *   / \   \
     *  5   3   9
     * @param root
     * @return
     */
    private static int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode curEnd = root;
        int curNode = 0;
        int max = 0;
        int res = -1;
        TreeNode nextEnd = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ++curNode;
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
                if(node.left != null){
                    nextEnd = node.left;
                }
                if(node.right != null){
                    nextEnd = node.right;
                }
                if(node == curEnd){
                    curEnd = nextEnd;
                    max = Math.max(curNode,max);
                    res = Math.max(res,max);
                    curNode = 0;
                }
            }
        }
        return res;
    }
}
