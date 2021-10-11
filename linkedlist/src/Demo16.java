import java.util.List;

/**
 * @Description
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/11 16:02
 **/
public class Demo16 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode listNode = swapPairs(node);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head.next;
        ListNode doubleNext = head.next.next;
        head.next.next = head;
        head.next = doubleNext;
        head.next = swapPairs(doubleNext);
        return tail;
    }
}
