import jdk.nashorn.internal.ir.LiteralNode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你不需要保留每个分区中各节点的初始相对位置。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/14 16:00
 **/
public class Demo10 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        ListNode res = partition2(head, 3);
    }

    /**
     * 双指针
     * @param head
     * @param x
     * @return
     */
    private static ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode tail = head;
        List<ListNode> list = new ArrayList<>();
        while(tail != null){
            list.add(tail);
            tail = tail.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while(left <= right){
            if(list.get(left).val >= x){
                if(list.get(right).val < x){
                    ListNode temp = list.get(left);
                    list.set(left,list.get(right));
                    list.set(right,temp);
                    ++left;
                    --right;
                } else{
                    --right;
                }
            } else{
                ++left;
                right = list.get(right).val < x ? right : right - 1;
            }
        }
        ListNode temp = new ListNode(-1);
        tail = temp;
        for (ListNode listNode : list) {
            tail.next = listNode;
            tail = tail.next;
        }
        tail.next = null;
        return temp.next;
    }

    /**
     * 两根链表
     * @param head
     * @param x
     * @return
     */
    private static ListNode partition2(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode tail = head;
        ListNode s = small;
        ListNode b = big;
        while(tail != null){
            if(tail.val < x){
                s.next = tail;
                s = s.next;
            }
            if(tail.val >= x){
                b.next = tail;
                b = b. next;
            }
            tail = tail.next;
        }
        s.next = big.next;
        b.next = null;
        return small.next;
    }
}
