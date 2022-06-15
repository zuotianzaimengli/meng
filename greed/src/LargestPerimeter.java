import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * @Author mengq
 * @Date 2022/6/14 16:01
 **/
public class LargestPerimeter {

    public static void main(String[] args) {
        int[] arr = {2,1,1};
        System.out.println(largestPerimeter(arr));
    }
    /**
     * 两边之和大于第三边，a+b>c,b+c>a,c+a>b;第二组：两边之差小于第三边
     *
     * 1，2，3，4，9，12
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int index = nums.length - 1;
        while(index >= 2){
            if(leagal(nums[index],nums[index - 1],nums[index - 2])) {
                return nums[index] + nums[index - 1] + nums[index - 2];
            }
            index --;
        }
        return res;
    }

    private static boolean leagal(int a,int b,int c){
        return a + b > c && a + c > b && b + c > a && Math.abs(a-b) < c && Math.abs(a-c) < b && Math.abs(b-c) < a;
    }
}
