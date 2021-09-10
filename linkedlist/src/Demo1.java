import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author mengq
 * @Date 2021/9/10 16:11
 **/
public class Demo1 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        reorderList2(node);
    }

    /**
     * 双端队列实现
     *
     * @param head
     */
    private static void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<ListNode>();
        ListNode tail = head;
        while(tail != null){
            deque.offerLast(tail);
            tail = tail.next;
        }
        while(!deque.isEmpty()){
            ListNode first = deque.pollFirst();
            ListNode last = deque.pollLast();
            first.next = last;
            if(tail != null){
                tail.next = first;
            }
            tail = last;
        }
        if(tail != null && tail.next != null){
            tail.next = null;
        }
    }

    /**
     * 先找中点，双数找上中点，然后反转后面的链表，后面的最后一个节点指向前面的最后一个节点
     * 再连新链表
     * @param head
     */
    private static void reorderList2(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        //先找中点，双数找上中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = null;
        ListNode pre = slow;
        ListNode tail = slow.next;
        slow.next = null;
        while(tail != null){
            next = tail.next;
            tail.next = pre;
            pre = tail;
            tail = next;
        }
        tail = head;
        ListNode temp = null;
        while(tail != null && pre != null){
            ListNode firstNext = tail.next;
            ListNode lastNode = pre.next;
            if(tail != pre) {
                tail.next = pre;
            }
            if(temp != null){
                temp.next = tail;
            }
            temp = pre;
            tail = firstNext;
            pre = lastNode;
        }
        temp.next = null;
    }


}
