import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author mengq
 * @Date 2021/9/11 15:29
 **/
public class Demo4 {

    public static void main(String[] args) {
        Node _1 = new Node(7,null,null);
        Node _2 = new Node(13,null,null);
        Node _3 = new Node(11,null,null);
        Node _4 = new Node(10,null,null);
        Node _5 = new Node(1,null,null);
        _1.next = _2;
        _1.random = null;
        _2.next = _3;
        _2.random = _1;
        _3.next = _4;
        _3.random = _5;
        _4.next = _5;
        _4.random = _3;
        _5.random = _1;
        clone2(_1);
    }

    /**
     * hashmap
     * @param node
     * @return
     */
    private static Node clone(Node node){
        Map<Node,Node> map = new HashMap<>();
        Node tail = node;
        while(tail != null){
            map.put(tail,new Node(tail.val,null,null));
            tail = tail.next;
        }
        tail = node;
        Node head = new Node(-1,null,null);
        Node t = head;
        while(tail != null){
            t.next = map.get(tail);
            t.next.random = map.get(tail.random);
            t = t.next;
            tail = tail.next;
        }
        return head.next;
    }

    private static Node clone2(Node node){
        if(node == null){
            return null;
        }
        Node tail = node;
        while(tail != null){
            Node next = tail.next;
            tail.next = new Node(tail.val,next,null);
            tail = next;
        }
        Node head = new Node(-1,null,null);
        Node t = head;
        tail = node;
        while(tail != null){
           Node next = tail.next;
           if(next != null){
               next.random = tail.random == null ? null : tail.random.next;
           }
           tail = tail.next == null ? null : tail.next.next;
        }
        tail = node;
        while(tail != null){
            t.next = tail.next;
            tail.next = tail.next == null ? null : tail.next.next;
            tail = tail.next;
            t = t.next;
        }
        return head.next;
    }

    private static final class Node{
        int val;

        Node next;

        Node random;

        public Node(int val,Node next,Node random){
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
