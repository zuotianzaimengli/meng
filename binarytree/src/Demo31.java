import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 *
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *
 * 提示：
 *
 * 树中的节点数介于1和10^4之间
 * -10^5 <= node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/28 17:20
 **/
public class Demo31 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right.left = new TreeNode(-7);
        root.right.right = new TreeNode(9);
        System.out.println(maxLevelSum(root));
    }

    private static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        long sum = 0;
        int index = 1;
        long max = Long.MIN_VALUE;
        int res = -1;
        queue.offer(root);
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
            sum += node.val;
            if(node == curEnd){
                if(sum >= max){
                    res = max == sum ? Math.min(res,index) : index;
                    max = sum;
                }
                curEnd = nextEnd;
                nextEnd = null;
                index++;
                sum = 0;
            }
        }
        return res;
    }
}
