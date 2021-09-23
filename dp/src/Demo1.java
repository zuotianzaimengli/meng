import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 打印字符串子序列
 * @Author mengq
 * @Date 2021/9/23 15:54
 **/
public class Demo1 {

    public static void main(String[] args) {
        List<String> list = func("aaa");
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    private static List<String> func(String string){
        List<String> list = new ArrayList<>();
        func(string.toCharArray(),0,"",list);
        return list;
    }

    private static void func(char[] arr,int index,String path,List<String> res){
        if(index == arr.length){
            res.add(path);
            return;
        }
        func(arr,index + 1,path,res);
        func(arr,index + 1,path + arr[index],res);
    }
}
