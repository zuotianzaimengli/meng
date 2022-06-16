
import java.util.Arrays;

/**
 * @Description
 * @Author mengq
 * @Date 2022/6/16 15:50
 **/
public class MinimumSum {

    public static void main(String[] args) {
        minimumSum(9876);
    }

    public static int minimumSum(int num){
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        char[] buf = new char[2];
        while(left <= right){
            buf[0] = arr[left++];
            buf[1] = arr[right--];
            res += Integer.parseInt(new String(buf));
            buf = new char[2];
        }
        return res;
    }
}
