/**
 * @Description
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/10 15:44
 **/
public class Demo17 {

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

    private static boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder,0,postorder.length - 1);
    }

    /**
     * 先找左树头节点，分开数组判断是否符合BST规范，递归左树，递归右树
     * @param postorder
     * @param left
     * @param right
     * @return
     */
    private static boolean verifyPostorder(int[] postorder,int left,int right){
        if(left >= right){
            return true;
        }
        //左树头节点
        int r = right;
        while(r >= left){
            if(postorder[r] < postorder[right]){
                break;
            }
            r--;
        }
        for(int index = r + 1;index < right;index++){
            if(postorder[index] < postorder[right]){
                return false;
            }
        }
        for(int index = left;index <= r;index++){
            if(postorder[index] > postorder[right]){
                return false;
            }
        }
        return verifyPostorder(postorder,left,r) && verifyPostorder(postorder, r + 1,right - 1);
    }
}
