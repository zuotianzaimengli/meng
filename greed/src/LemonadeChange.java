import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2022/6/14 15:37
 **/
public class LemonadeChange {
    public static void main(String[] args) {
        int[] arr = {10,10};
        System.out.println(lemonadeChange(arr));
    }

    /**
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> map = new HashMap<>(3);
        for (int bill : bills) {
            if(bill == 5) {
                map.put(5,map.getOrDefault(5,0) + 1);
            }
            if(bill == 10) {
                if(map.getOrDefault(5,0) == 0){
                    return false;
                } else{
                    map.put(10,map.getOrDefault(10,0) + 1);
                    map.put(5,map.get(5) - 1);
                }
            }
            if(bill == 20) {
                //优先找10美元
                if(map.getOrDefault(10,0) > 0 && map.getOrDefault(5,0) > 0) {
                    map.put(10,map.get(10) - 1);
                    map.put(5,map.get(5) - 1);
                } else {
                    if(map.getOrDefault(5,0) < 3) {
                        return false;
                    }
                    map.put(5,map.get(5) - 3);
                }
                map.put(20,map.getOrDefault(20,0) + 1);
            }
        }
        return true;
    }
}
