import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 根据先序、中序build二叉树
 * @Author mengq
 * @Date 2021/9/7 11:23
 **/
public class Demo3 {
    public static void main(String[] args) {
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        TreeNode res = buildTree(a, b);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder){
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(preorder).forEach(queue::offer);
        return buildTree(queue,inorder);
    }

    private static TreeNode buildTree(Queue<Integer> preQueue,int[] inOrder){
        if(preQueue.isEmpty() || inOrder == null || inOrder.length == 0){
            return null;
        }
        Integer val = preQueue.poll();
        TreeNode head = new TreeNode(val);
        int index = 0;
        while(index < inOrder.length){
            if(inOrder[index] == val){
                break;
            }
            index++;
        }
        head.left = buildTree(preQueue,Arrays.copyOfRange(inOrder,0,index));
        head.right = buildTree(preQueue,Arrays.copyOfRange(inOrder,index + 1,inOrder.length));
        return head;
    }
}
