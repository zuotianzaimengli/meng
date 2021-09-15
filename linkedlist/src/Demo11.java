/**
 * @Description
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/15 14:40
 **/
public class Demo11 {

    /**
     * 组一个单数链表，一个双数链表，连起来
     * @param head
     * @return
     */
    private static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tail = head;
        int index = 1;
        ListNode single = new ListNode(-1);
        ListNode doub = new ListNode(-1);
        ListNode s = single;
        ListNode d = doub;
        while(tail != null){
            if(index++ % 2 == 0){
                d.next = tail;
                d = d.next;
            } else{
                s.next = tail;
                s = s.next;
            }
            tail = tail.next;
        }
        d.next = null;
        s.next = doub.next;
        return single.next;
    }
}
