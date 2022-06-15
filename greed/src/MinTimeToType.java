/**
 * @Description
 * 有一个特殊打字机，它由一个 圆盘 和一个 指针组成， 圆盘上标有小写英文字母'a' 到'z'。只有当指针指向某个字母时，它才能被键入。指针 初始时指向字符 'a'。
 *
 *
 * 每一秒钟，你可以执行以下操作之一：
 *
 * 将指针 顺时针或者 逆时针移动一个字符。
 * 键入指针 当前指向的字符。
 * 给你一个字符串word，请你返回键入word所表示单词的 最少秒数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-time-to-type-word-using-special-typewriter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2022/6/15 16:00
 **/
public class MinTimeToType {

    /**
     * a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minTimeToType("bbbbbbb"));
    }

    /**
     * 1,2,3,4,5,6,7,8,9,10
     * a:97 z:122
     * @param word
     * @return
     */
    public static int minTimeToType(String word) {
        char[] arr = word.toCharArray();
        int res = 0;
        int index = 0;
        if(arr[index] != 'a') {
            int clock = getClockwiseDistance('a',arr[index]);
            int antic = getanticlockwiseDistance('a',arr[index]);
            int distance = Math.min(clock,antic);
            res += distance + 1;
        } else{
            res+=1;
        }
        while(index < arr.length){
            if(index == arr.length - 1) {
                break;
            } else{
                int distance = Math.min(getClockwiseDistance(arr[index],arr[index + 1]),getanticlockwiseDistance(arr[index],arr[index + 1]));
                res += distance + 1;
            }
            index++;
        }
        return res;
    }

    /**
     * 顺时针
     * @param begin
     * @param end
     * @return
     */
    private static int getClockwiseDistance(char begin,char end){
        if(end >= begin) {
            return end - begin;
        }
        return 122 - begin + end - 97 + 1;
    }

    /**
     * 逆时针
     * @param begin
     * @param end
     * @return
     */
    private static int getanticlockwiseDistance(char begin,char end) {
        if(begin >= end) {
            return begin - end;
        }
        return begin - 97 + 122 - end + 1;
    }

}
