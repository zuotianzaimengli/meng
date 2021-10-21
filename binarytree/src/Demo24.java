import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 *
 * 节点p的后继是值比p.val大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例2：
 *
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/P5rCT8
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/21 15:19
 **/
public class Demo24 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        inorderSuccessor(root,root.left);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        forEach(root,list);
        int i = Collections.binarySearch(list, p, (x, y) -> x.val - y.val);
        if(i == -1 || i >= list.size() - 1){
            return null;
        }
        return list.get(i + 1);
    }

    private static void forEach(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        forEach(root.left,list);
        list.add(root);
        forEach(root.right,list);
    }
}
