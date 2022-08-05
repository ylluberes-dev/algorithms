import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveLinkedListElements {


    static int findMergeNode(ListNode head1, ListNode head2) {

        ListNode cur = head1;

        while (cur != null) {
            ListNode other = head2;
            while (other != null) {
                if(other.next == cur.next){
                    return cur.next.value;
                }
                other = other.next;
            }
            cur = cur.next;
        }
        return -1;
    }

    boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> values = new HashSet<>();
        ListNode cur = head;
        ListNode temp = cur;
        while (cur != null) {

            cur = cur.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode tempNext = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempNext;

        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);

        new RemoveLinkedListElements().reverse(node);

        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(1);
        second.next = first.next;

        /*ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(1);
        second.next = first.next.next;*/



        System.out.println(findMergeNode(first,second));

    }
}
