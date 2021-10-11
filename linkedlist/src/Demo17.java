import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/11 16:10
 **/
public class Demo17 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))));
        ListNode listNode = deleteDuplicates(node);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode tail = head;
        Set<Integer> set = new HashSet<>();
        while(tail != null){
            if(pre.val == tail.val){
                set.add(tail.val);
            }
            pre = tail;
            tail = tail.next;
        }
        tail = head;
        pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode temp = pre;
        while(tail != null){
            if(set.contains(tail.val)){
                pre.next = tail.next;
                tail = pre.next;
            } else{
                pre = tail;
                tail = tail.next;
            }
        }
        return temp.next;
    }
}
