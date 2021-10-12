import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 示例 3：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 示例 4：
 *
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 示例 5：
 *
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
