import java.util.*;

/**
 * @Description 二叉树右视图
 * @Author mengq
 * @Date 2021/9/7 14:58
 **/
public class Demo6 {

    public static void main(String[] args) {
        /*TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(5);
        head.right.right = new TreeNode(4);
        List<Integer> integers = rightSideView(head);*/
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        List<Integer> integers = rightSideView(head);
    }

    private static List<Integer> rightSideView(TreeNode root){
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                nextEnd = node.left;
                queue.offer(node.left);
            }
            if(node.right != null){
                nextEnd = node.right;
                queue.offer(node.right);
            }
            if(node == curEnd){
                list.add(node.val);
                curEnd = nextEnd;
            }
        }
        return list;
    }
}
