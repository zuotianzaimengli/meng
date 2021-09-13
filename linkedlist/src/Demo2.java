import java.util.Stack;

/**
 * @Description
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UHnkqh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/11 14:33
 **/
public class Demo2 {

    /**
     * 栈
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tail = head;
        while(tail != null){
            stack.push(tail);
            tail = tail.next;
        }
        ListNode temp = new ListNode(-1);
        tail = temp;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return temp.next;
    }

    /**
     * 指针移动
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        ListNode tail = head;
        while(tail != null){
            next = tail.next;
            tail.next = pre;
            pre = tail;
            tail = next;
        }
        return pre;
    }

}
