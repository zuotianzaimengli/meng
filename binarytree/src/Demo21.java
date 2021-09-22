import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定二叉搜索树的根结点root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/22 15:48
 **/
public class Demo21 {
    private static int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        forEach(root,list);
        int res = 0;
        for (Integer num : list) {
            if(num >= low && num <= high){
                res += num;
            }
        }
        return res;
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
