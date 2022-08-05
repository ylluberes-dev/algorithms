import java.util.HashMap;
import java.util.Stack;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        System.out.println(node);

        ListNode temp = node.next;
        System.out.println();
        Stack<int[]> values = new Stack<>();

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode (5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        new DeleteNode().deleteNode(node.next);

        // 4 -> 5 -> 1 -> 9
        // 4 -> 1 -> 1 -> 9
        // 4 -> 1 -> 9

    }
}
