import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * @Author mengq
 * @Date 2021/10/12 15:20
 **/
public class Demo19 {

    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * hashmap
     * @param head
     * @param k
     * @return
     */
    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        int begin = k;
        int len = 0;
        int index = 1;
        Map<Integer,Integer> map = new HashMap<>();
        while(tail != null){
            len++;
            map.put(index++,tail.val);
            tail = tail.next;
        }
        int end = len - k + 1;
        tail = head;
        index = 1;
        while(tail != null){
            if(index == begin){
                tail.val = map.get(end);
            }
            if(index == end){
                tail.val = map.get(begin);
            }
            index++;
            tail = tail.next;
        }
        return head;
    }


    /**
     * 双指针找正数第k个node和倒数第k个node
     * @param head
     * @param k
     * @return
     */
    public static ListNode swapNodes2(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }
        int index = 1;
        ListNode tail = head;
        ListNode pre = null;
        ListNode behind = null;
        while(index++ <= k){
            pre = tail;
            tail = tail.next;
        }
        tail = head;
        behind = pre;
        while(behind.next != null){
            tail = tail.next;
            behind = behind.next;
        }
        behind = tail;
        if(pre != behind) {
            pre.val = pre.val ^ behind.val;
            behind.val = pre.val ^ behind.val;
            pre.val = pre.val ^ behind.val;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = swapNodes2(head, 3);
    }
}
