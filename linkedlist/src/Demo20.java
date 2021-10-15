import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vvXgSW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/15 15:32
 **/
public class Demo20 {

    /**
     * 先排序，再组链表
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        for (ListNode node : lists) {
            ListNode tail = node;
            while (tail != null) {
                list.add(tail);
                tail = tail.next;
            }
        }
        sort(list);
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (ListNode listNode : list) {
            listNode.next = null;
            tail.next = listNode;
            tail = tail.next;
        }
        return head.next;
    }

    private static void sort(List<ListNode> lists){
        sort(lists,0,lists.size() - 1);
    }

    private static void sort(List<ListNode> lists,int begin,int end){
        if(begin >= end){
            return;
        }
        int middle = begin + ((end - begin) >> 1);
        sort(lists,begin,middle);
        sort(lists,middle + 1,end);
        merge(lists,begin,end,middle);
    }

    private static void merge(List<ListNode> lists,int begin,int end,int middle){
        int left = begin;
        int right = middle + 1;
        List<ListNode> temp = new ArrayList<>(end - begin + 1);
        while(left <= middle && right <=end){
            temp.add(lists.get(left).val <= lists.get(right).val ? lists.get(left++) : lists.get(right++));
        }
        while(left <= middle){
            temp.add(lists.get(left++));
        }
        while(right <= end){
            temp.add(lists.get(right++));
        }
        for (ListNode node : temp) {
            lists.set(begin++,node);
        }
    }

    public static void main(String[] args) {
        List<ListNode> list = Arrays.asList(new ListNode(1), new ListNode(4), new ListNode(3), new ListNode(2));
        sort(list);
    }
}


