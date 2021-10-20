import java.util.*;

/**
 * @Description
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/20 15:15
 **/
public class Demo21 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        ListNode[] listNodes = listOfDepth(head);
    }

    private static ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return null;
        }
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        TreeNode curEnd = tree;
        TreeNode nextEnd = null;
        ListNode head = null;
        ListNode tail = head;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                nextEnd = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextEnd = node.right;
            }
            if(head == null){
                head = new ListNode(node.val);
                tail = head;
            } else{
                tail.next = new ListNode(node.val);
                tail = tail.next;
            }
            if(node == curEnd){
                res.add(head);
                head = null;
                tail = head;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return res.toArray(new ListNode[0]);
    }
}
