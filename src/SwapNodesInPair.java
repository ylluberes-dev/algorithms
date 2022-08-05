public class SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {

       /* if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode savePont = cur.next;
            prev.next = savePont;
            cur.next = prev;

            prev = savePont;
            cur = prev.next;
        }
        return head;*/

        return null;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = new SwapNodesInPair().swapPairs(head);
        System.out.println("Stop");
    }
}
