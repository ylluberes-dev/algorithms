public class MergeSortedList {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode();
        while(head1 != null && head2 != null){

        }

        return null;
    }

    public static void main(String[] args) {
        /**
         * Input: l1 = [1,2,4], l2 = [1,3,4]
         * Output: [1,1,2,3,4,4]
         */
        final ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        final ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode result = new MergeSortedList().mergeTwoLists(l1,l2);


    }
}
