import java.util.Arrays;

/**
 * @Description
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 * 示例 2：
 *
 *
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/9 14:39
 **/
public class Demo14 {

    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3,2,1});
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums == null ? 0 : nums.length - 1);
    }

    /**
     * 方法一
     * @param nums
     * @return
     */
    /*private static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int max = -1;
        int index = 0;
        for (int i = 0;i < nums.length;i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode head = new TreeNode(max);
        head.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
        head.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index + 1,nums.length));
        return head;
    }*/

    /**
     * 方法二
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static TreeNode constructMaximumBinaryTree(int[] nums,int left,int right){
        if(right < left){
            return null;
        }
        int max = -1;
        int index = left;
        for (int i = left;i <= right;i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode head = new TreeNode(max);
        head.left = constructMaximumBinaryTree(nums,left,index - 1);
        head.right = constructMaximumBinaryTree(nums,index + 1,right);
        return head;
    }
}
