/**
 * @Description
 * 给定一个链表的 头节点head，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 *
 *
 *
 * 输入: head = [1,2]
 * 输出: fasle
 *
 * 提示：
 *
 * 链表 L 的长度范围为 [1, 105]
 * 0<= node.val <= 9
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aMhZSa
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/11 14:41
 **/
public class Demo3 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        isPalindrome(head);
    }


    /**
     * 1 -> 2 -> 3 -> 2 -> 1
     * @param head
     * @return
     */
    private static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow;
        ListNode tail = slow.next;
        slow.next = null;
        while(tail != null){
            ListNode next = tail.next;
            tail.next = pre;
            pre = tail;
            tail = next;
        }
        ListNode left = head;
        ListNode right = pre;
        boolean res = true;
        while(left != null && right != null){
            if(left.val != right.val){
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        tail = pre;
        pre = null;
        while(tail != null){
            ListNode next = tail.next;
            tail.next = pre;
            pre = tail;
            tail = next;
        }
        slow.next = pre;
        return res;
    }
}
