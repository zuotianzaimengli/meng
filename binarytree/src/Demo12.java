import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个二叉搜索树的 根节点 root和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 *
 *
 * 示例 1：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/opLdQZ
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/8 18:28
 **/
public class Demo12 {

    private static boolean findTarget(TreeNode root, int k) {
        List<Integer> list =  new ArrayList<>();
        mid(root,list);
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int l = list.get(left);
            int r = list.get(right);
            if(l + r == k){
                return true;
            }
            if(l + r > k){
                right --;
            }
            if(l + r < k){
                left ++;
            }
        }
        return false;
    }

    private static void mid(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        mid(root.left,list);
        list.add(root.val);
        mid(root.right,list);
    }
}
