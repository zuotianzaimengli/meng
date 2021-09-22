import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/22 16:23
 **/
public class Demo22 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(111);
        head.right = new TreeNode(322);
        String serialize = serialize(head);
        TreeNode node = deserialize(serialize);
    }
    // Encodes a tree to a single string.
    private static String serialize(TreeNode root) {
        return serialize(root,"").substring(1);
    }

    private static String serialize(TreeNode root,String str){
        if(root == null){
            return str + ",n";
        }
        str += "," + root.val;
        return serialize(root.right,serialize(root.left,str));
    }

    // Decodes your encoded data to tree.
    private static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        Arrays.stream(data.split(",")).forEach(queue::offer);
        return deserialize(queue);
    }

    private static TreeNode deserialize(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        String str = queue.poll();
        if("n".equals(str)){
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(str));
        head.left = deserialize(queue);
        head.right = deserialize(queue);
        return head;
    }
}
