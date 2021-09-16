import java.util.Stack;

/**
 * @Description
 * @Author mengq
 * @Date 2021/9/15 16:51
 **/
public class Demo18 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        behand(head);
    }

    private static void pre(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode head = stack.pop();
            if(head != null){
                System.out.println(head.val);
                stack.push(head.right);
                stack.push(head.left);
            }
        }
    }

    private static void mid(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(head != null || !stack.isEmpty()){
            if(head != null){
                stack.push(head);
                head = head.left;
            } else{
                TreeNode node = stack.pop();
                if(node != null){
                    System.out.println(node.val);
                    head = node.right;
                }
            }
        }
    }

    private static void behand(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            if(node != null){
                s2.push(node);
                s1.push(node.left);
                s1.push(node.right);
            }
        }
        while(!s2.isEmpty()){
            TreeNode node = s2.pop();
            if(node != null){
                System.out.println(node.val);
            }
        }
    }
}
