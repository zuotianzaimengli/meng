import java.util.Arrays;

/**
 * @Description
 * 、给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 *
 * 返回该 最大总和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/array-partition-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2022/5/26 18:03
 **/
public class ArrayPairSum {
    public static int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for(int i =0;i < nums.length;i=i+2) {
            res+=Math.min(nums[i] , nums[i+1]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.min(-10,-5) + Math.min(-5,0) + Math.min(0,5) + Math.min(5,10));
    }
}
