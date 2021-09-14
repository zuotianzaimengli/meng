import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/14 10:38
 **/
public class Demo8 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode res = rotateRight2(head, 2);
    }
    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode tail = head;
        ListNode end = null;
        int len = 0;
        while(tail != null){
            len++;
            end = tail.next == null ? tail : null;
            tail = tail.next;
        }
        k = k % len;
        int target = k == 0 ? 1 : len - k + 1;
        if(target == 1){
            return head;
        }
        tail = head;
        int index = 1;
        ListNode pre = null;
        while(tail != null){
            if(index++ == target){
                if(pre != null){
                    pre.next = null;
                }
                break;
            }
            pre = tail;
            tail = tail.next;
        }
        end.next = head;
        return tail;
    }

    /**
     * deque
     * @param head
     * @param k
     * @return
     */
    private static ListNode rotateRight2(ListNode head, int k){
        if(head == null){
            return null;
        }

        Deque<ListNode> deque = new LinkedList<>();
        ListNode tail = head;
        while(tail != null){
            deque.offer(tail);
            tail = tail.next;
        }
        k = k % deque.size();
        if(k == 0){
            return head;
        }
        tail = null;
        ListNode end = deque.peekLast();
        while(k-- > 0){
            ListNode node = deque.pollLast();
            node.next = tail;
            tail = node;
        }
        while(!deque.isEmpty()){
            end.next = deque.pollFirst();
            end = end.next;
        }
        end.next = null;
        return tail;
    }
}
