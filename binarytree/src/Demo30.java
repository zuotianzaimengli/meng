import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0,10^4] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/25 16:01
 **/
public class Demo30 {

    /**
     * 递归
     * @param root
     * @return
     */
    private static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    private static void preorder(Node root,List<Integer> res) {
        if(root == null){
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child,res);
        }
    }

    /**
     * 循环
     * @param root
     * @return
     */
    private static List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node != null) {
                list.add(node.val);
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
