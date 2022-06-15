import java.util.Arrays;

/**
 * @Description
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2022/6/14 17:43
 **/
public class LargestSumAfterKNegations {

    public static void main(String[] args) {
        int[] arr = {5,6,9,-3,3};
        System.out.println(largestSumAfterKNegations(arr,2));
    }

    /**
     * -1,0,1,2,3,4,5,6,7
     *
     * 排序
     * 1.k <= 小于0的个数
     * 2.k > 小于0的个数 -> k - 小于0的个数 % 2 == 0 ? 无所谓 ： 所有负数取反，取最小的数再取反
     * @param nums
     * @param k
     * @return
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int less = Arrays.stream(nums).map(num -> num < 0 ? 1 : 0).sum();
        if(k <= less) {
            int res = 0;
            for (int num : nums) {
                if (k-- > 0) {
                    res += Math.abs(num);
                } else {
                    res += num;
                }
            }
            return res;
        }
        if((k - less) % 2 == 0) {
            return Arrays.stream(nums).map(Math::abs).sum();
        }
        int[] temp = Arrays.stream(nums).map(Math::abs).toArray();
        Arrays.sort(temp);
        temp[0] = -temp[0];
        return Arrays.stream(temp).sum();
    }
}
