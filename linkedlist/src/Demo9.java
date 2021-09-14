import java.util.Stack;

/**
 * @Description
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/14 15:39
 **/
public class Demo9 {

    public static void main(String[] args) {
        ListNode head = new ListNode(9,new ListNode(9,new ListNode(9)));
        ListNode h2 = new ListNode(1,new ListNode(1));
        ListNode listNode = addTwoNumbers2(head, h2);
    }

    /**
     * 倒放
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        ListNode head = new ListNode(-1);
        ListNode t = head;
        boolean flag = false;
        while(tail1 != null || tail2 != null){
            int val1 = tail1 == null ? 0 : tail1.val;
            int val2 = tail2 == null ? 0 : tail2.val;
            int sum = flag ? val1 + val2 + 1 : val1 + val2;
            flag = sum >= 10;
            sum %= 10;
            t.next = new ListNode(sum);
            t = t.next;
            tail1 = tail1 == null ? null : tail1.next;
            tail2 = tail2 == null ? null : tail2.next;
        }
        if(flag){
            t.next = new ListNode(1);
        }
        return head.next;
    }

    /**
     * 正方
     * 1 2 3
     *   4 5
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        while(tail1 != null || tail2 != null){
            if(tail1 != null){
                s1.push(tail1);
            }
            if(tail2 != null){
                s2.push(tail2);
            }
            tail1 = tail1 == null ? null : tail1.next;
            tail2 = tail2 == null ? null : tail2.next;
        }
        ListNode head = null;
        boolean flag = false;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int v1 = s1.isEmpty() ? 0 : s1.pop().val;
            int v2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = flag ? v1 + v2 + 1 : v1 + v2;
            flag = sum >= 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        if(flag){
            ListNode n = new ListNode(1);
            n.next = head;
            return n;
        }
        return head;
    }
}
