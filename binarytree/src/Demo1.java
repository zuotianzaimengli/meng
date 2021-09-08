/**
 * @Description 是否是平衡二叉树
 * @Author mengq
 * @Date 2021/9/7 10:53
 **/
public class Demo1 {
    public static void main(String[] args) {

    }


    private static boolean isBalanced(TreeNode head){
        return func(head).isBalance;
    }

    private static Info func(TreeNode head){
        if(head == null){
            return new Info(0,true);
        }
        Info left = func(head.left);
        Info right = func(head.right);
        if(left.isBalance && right.isBalance && Math.abs(left.height - right.height) <= 1){
            return new Info(Math.max(left.height,right.height) + 1,true);
        }
        return new Info(Math.max(left.height,right.height) + 1,false);
    }

    private static final class Info{
        int height;

        boolean isBalance;

        public Info(int height,boolean isBalance){
            this.height = height;
            this.isBalance = isBalance;
        }
    }
}
