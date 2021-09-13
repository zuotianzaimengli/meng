/**
 * @Description
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/13 18:07
 **/
public class Demo7 {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode tailA = headA;
        ListNode tailB = headB;
        boolean flagA = false;
        boolean flagB = false;
        while(tailA != null || tailB != null){
            if(tailB != null && tailA == tailB){
                return tailA;
            }
            if(tailA == null && !flagA){
                tailA = headB;
                flagA = true;
            } else{
                tailA = tailA == null ? null : tailA.next;
            }
            if(tailB == null && !flagB){
                tailB = headA;
                flagB = true;
            }else{
                tailB = tailB == null ? null : tailB.next;
            }
        }
        return null;
    }
}
