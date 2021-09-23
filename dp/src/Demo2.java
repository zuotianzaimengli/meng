import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * 字符串全排列
 * @Author mengq
 * @Date 2021/9/23 16:14
 **/
public class Demo2 {

    public static void main(String[] args) {
        function("abc").forEach(System.out::println);
    }

    private static List<String> function(String str){
        List<String> list = new ArrayList<>();
        function2(str.toCharArray(),0,list);
        return list;
    }

    /**
     * index到最后的每个字符和index交换
     * 深度优先遍历
     * @param arr
     * @param index
     * @param res
     */
    private static void function(char[] arr,int index,List<String> res){
        if(index == arr.length){
            res.add(new String(arr));
        }
        for(int i = index;i < arr.length;i++){
            char ch = arr[index];
            arr[index] = arr[i];
            arr[i] = ch;
            function(arr, index + 1, res);
            arr[i] = arr[index];
            arr[index] = ch;
        }
    }

    /**
     * 字符串全排列，不重复
     * 深度优先遍历
     * 分支限界
     * 如果当前i位置的字符之前已经深度遍历过，就不继续了
     * @param arr
     * @param index
     * @param res
     */
    private static void function2(char[] arr,int index,List<String> res){
        if(index == arr.length){
            res.add(new String(arr));
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if(set.add(arr[i])){
                char ch = arr[index];
                arr[index] = arr[i];
                arr[i] = ch;
                function(arr, index + 1, res);
                arr[i] = arr[index];
                arr[index] = ch;
            }
        }
    }
}
