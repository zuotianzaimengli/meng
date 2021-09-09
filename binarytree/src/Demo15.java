import com.sun.deploy.panel.ITreeNode;
import sun.jvm.hotspot.memory.HeapBlock;

/**
 * @Description
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/9 15:15
 **/
public class Demo15 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(6);
        System.out.println(isValidBST(head));

        head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(4);
        System.out.println(isValidBST(head));

        head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
        System.out.println(isValidBST(head));

        head = new TreeNode(1);
        head.left = new TreeNode(1);
        System.out.println(isValidBST(head));
    }

    private static boolean isValidBST(TreeNode root) {
         return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }
        if(root.val < max && root.val > min){
            return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
        }
        return false;
    }
}
