import java.util.*;

/**
 * @Description
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
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
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/10/26 15:18
 **/
public class Demo23 {
    public static void main(String[] args) {
        ListNode _1 = new ListNode(1,new ListNode(2));
        ListNode _2 = new ListNode(3,new ListNode(5));
        ListNode _3 = new ListNode(2,new ListNode(4));
        ListNode[] arr = {_1,_2,_3};
        ListNode listNode = mergeKLists(arr);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode head = new ListNode(-1);
        for (int i = 0;i < lists.length;i++) {
            ListNode tail = lists[i];
            while(tail != null){
                if(tail.next == null){
                    map.put(i,tail);
                    break;
                }
                tail = tail.next;
            }
        }
        ListNode tail = head;
        for(int i = 0;i < lists.length;i++){
            if(map.get(i) != null){
                tail.next = lists[i];
                tail = map.get(i);
            }
        }
        return sortList(head.next);
    }

    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        List<ListNode> list = new ArrayList<>();
        while(tail != null){
            list.add(tail);
            tail = tail.next;
        }
        sort(list,0,list.size() - 1);
        ListNode res = new ListNode(-1);
        tail = res;
        for (ListNode node : list) {
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return res.next;
    }

    private static void sort(List<ListNode> list,int begin,int end){
        if(begin >= end){
            return;
        }
        int middle = begin + ((end - begin) >> 1);
        sort(list,begin,middle);
        sort(list,middle + 1,end);
        merge(list,begin,end,middle);
    }

    private static void merge(List<ListNode> list,int left,int right,int middle){
        ListNode[] temp = new ListNode[right - left + 1];
        int l = left;
        int r = middle + 1;
        int index = 0;
        while(l <= middle && r <= right){
            temp[index++] = list.get(l).val <=list.get(r).val ? list.get(l++) : list.get(r++);
        }
        while(l <= middle){
            temp[index++] = list.get(l++);
        }
        while(r <= right){
            temp[index++] = list.get(r++);
        }
        for (ListNode node : temp) {
            list.set(left++,node);
        }
    }
}
