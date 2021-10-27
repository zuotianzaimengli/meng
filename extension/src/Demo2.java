import java.util.Arrays;

/**
 * @Description
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/27 15:23
 **/
public class Demo2 {
    private static boolean isUnique(String astr) {
        if(astr == null || astr.length() == 0){
            return true;
        }
        char[] arr = astr.toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(i != arr.length - 1){
                if((arr[i] ^ arr[i + 1]) == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
