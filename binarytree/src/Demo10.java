import java.util.*;

/**
 * @Description 二叉树每层最大值
 * @Author mengq
 * @Date 2021/9/8 11:27
 **/
public class Demo10 {

    private static List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode currentEnd = root;
        TreeNode nextEnd = null;
        Integer max = null;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                nextEnd = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextEnd = node.right;
            }
            max = max == null ? node.val : Math.max(max,node.val);
            if(node == currentEnd){
                currentEnd = nextEnd;
                res.add(max);
                max = null;
            }
        }
        return res;
    }
}
