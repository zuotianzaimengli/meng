/**
 * @Description
 * @Author mengq
 * @Date 2021/10/27 15:41
 **/
public class Demo4 {
    private static String replaceSpaces(String S, int length) {
        if(S == null || S.length() == 0){
            return S;
        }
        int index = length - 1;
        while(length >= 0){
            if(S.charAt(length--) == ' '){
                index--;
            }
        }
        S = S.substring(0,index);
        return null;
    }

    public static void main(String[] args) {
        replaceSpaces("Mr John Smith    ",13);
    }
}
