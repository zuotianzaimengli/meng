/**
 * @Description
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/15 15:07
 **/
public class Demo13 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = reverseBetween(head, 1, 4);
        head = new ListNode(5);
        ListNode res = reverseBetween(head, 1, 1);
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        int index = 1;
        ListNode pre = null;
        ListNode next = null;
        ListNode tail = head;
        ListNode begin = null;
        ListNode end = null;
        while(tail != null){
            if(index + 1 == left){
                pre = tail;
            }
            if(index == left){
                begin = tail;
            }
            if(index == right){
                next = tail.next;
                end = tail;
                break;
            }
            index++;
            tail = tail.next;
        }
        end.next = null;
        ListNode p = null;
        tail = begin;
        while(tail != null){
            ListNode t = tail.next;
            tail.next = p;
            p = tail;
            tail = t;
        }
        begin.next = next;
        if(pre == null){
            return p;
        }
        pre.next = p;
        return head;
    }
}
