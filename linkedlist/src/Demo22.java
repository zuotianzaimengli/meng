import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/7WHec2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/20 15:35
 **/
public class Demo22 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
        sortList(head);
    }

    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        List<ListNode> list = new ArrayList<>();
        while(tail != null){
            list.add(tail);
            tail = tail.next;
        }
        sort(list,0,list.size() - 1);
        ListNode res = new ListNode(-1);
        tail = res;
        for (ListNode node : list) {
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return res.next;
    }

    private static void sort(List<ListNode> list,int begin,int end){
        if(begin >= end){
            return;
        }
        int middle = begin + ((end - begin) >> 1);
        sort(list,begin,middle);
        sort(list,middle + 1,end);
        merge(list,begin,end,middle);
    }

    private static void merge(List<ListNode> list,int left,int right,int middle){
        ListNode[] temp = new ListNode[right - left + 1];
        int l = left;
        int r = middle + 1;
        int index = 0;
        while(l <= middle && r <= right){
            temp[index++] = list.get(l).val <=list.get(r).val ? list.get(l++) : list.get(r++);
        }
        while(l <= middle){
            temp[index++] = list.get(l++);
        }
        while(r <= right){
            temp[index++] = list.get(r++);
        }
        for (ListNode node : temp) {
            list.set(left++,node);
        }
    }
}
