/**
 * @Description
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 *
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 *
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 *
 * 返回将current 转化为 correct 需要的 最少操作数 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2022/6/16 16:06
 **/
public class ConvertTime {


    /**
     * 1439 % 60 = 239
     * 239 % 15 =
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convertTime("00:00", "23:59"));
    }

    /**
     * 输入：current = "02:30", correct = "04:35"
     * 输出：3
     * 解释：
     * 可以按下述 3 步操作将 current 转换为 correct ：
     * - 为 current 加 60 分钟，current 变为 "03:30" 。
     * - 为 current 加 60 分钟，current 变为 "04:30" 。
     * - 为 current 加 5 分钟，current 变为 "04:35" 。
     * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param current
     * @param correct
     * @return
     */
    public static int convertTime(String current, String correct) {
        //275   -  150 = 125
        String[] cu = current.split(":");
        String[] co = correct.split(":");
        int cuM = Integer.parseInt(cu[0]) * 60 + Integer.parseInt(cu[1]);
        int coM = Integer.parseInt(co[0]) * 60 + Integer.parseInt(co[1]);
        int distance = coM - cuM;
        int res = 0;
        int temp = distance % 60;
        if(temp == 0) {
            return distance / 60;
        }
        res += distance / 60;
        distance -= distance / 60 * 60;
        temp = temp % 15;
        if(temp == 0) {
            res += distance / 15;
            return res;
        }
        res += distance / 15;
        distance -= distance / 15 * 15;
        temp = temp % 5;
        if(temp == 0){
            res += distance / 5;
            return res;
        }
        res += distance / 5;
        distance -= distance / 5 * 5;
        return res + distance;
    }
}
