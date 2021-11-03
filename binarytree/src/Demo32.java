import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第k个最小元素（从 1 开始计数）。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/11/1 15:35
 **/
public class Demo32 {
    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        forEach(root, res);
        return res.get(k - 1);
    }

    private static void forEach(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        forEach(root.left,list);
        list.add(root.val);
        forEach(root.right,list);
    }
}
