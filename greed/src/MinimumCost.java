import java.util.Arrays;

/**
 * @Description
 * 一家商店正在打折销售糖果。每购买 两个糖果，商店会 免费送一个糖果。
 *
 * 免费送的糖果唯一的限制是：它的价格需要小于等于购买的两个糖果价格的 较小值。
 *
 * 比方说，总共有 4个糖果，价格分别为1，2，3和4，一位顾客买了价格为2 和3的糖果，那么他可以免费获得价格为 1的糖果，但不能获得价格为4的糖果。
 * 给你一个下标从 0开始的整数数组cost，其中cost[i]表示第i个糖果的价格，请你返回获得 所有糖果的 最小总开销。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2022/6/16 15:14
 **/
public class MinimumCost {

    public static void main(String[] args) {
        int[] arr = {3};
        System.out.println(minimumCost(arr));
    }

    /**
     * cost = [6,5,7,9,2,2]
     * @param cost
     * @return
     */
    public static int minimumCost(int[] cost) {
           // 2 2 5 6 7 9 = 7 + 16 = 23
        Arrays.sort(cost);
        int flag = 0;
        boolean free = false;
        int res = 0;
        int index = cost.length - 1;
        while(index >= 0){
            if(free) {
                index--;
                free = false;
                flag = 0;
            } else {
                res += cost[index];
                if(++flag == 2){
                    free = true;
                }
                index--;
            }
        }
        return res;
    }
}
