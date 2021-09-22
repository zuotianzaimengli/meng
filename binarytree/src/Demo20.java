import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/22 15:34
 **/
public class Demo20 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(5);
        List<String> list = binaryTreePaths(head);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePaths(root,list,"");
        return list;
    }

    private static void binaryTreePaths(TreeNode root,List<String> list,String path){
        path = path + "->" + root.val;
        if(root.left == null && root.right == null){
            list.add(path.substring(2));
            return;
        }
        if(root.left != null){
            binaryTreePaths(root.left,list,path);
        }
        if(root.right != null){
            binaryTreePaths(root.right,list,path);
        }
    }

}
