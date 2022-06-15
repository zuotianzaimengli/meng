/**
 * @Description 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 * @Author mengq
 * @Date 2022/6/15 15:29
 **/
public class Maximum69Number {

    public static void main(String[] args) {

    }
    public static int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '6'){
                arr[i] = '9';
                return Integer.parseInt(new String(arr));
            }
        }
        return num;
    }
}
