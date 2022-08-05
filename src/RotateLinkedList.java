public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {

        int count = 0;
        while(count < k){
            ListNode prev = null;
            ListNode cur = head;

            while(cur.next != null){
                                //prev
                // 1 -> 2 -> 3 -> 4 -> 5
                prev = cur; // Reaching the prev last element
                cur = cur.next; // Reaching the last element;
            }

            cur.next = head;
            prev.next = null;
            count++;
            head = cur;
        }
        return head;
    }

    public ListNode rotateRight2(ListNode head, int k) {

        int size = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            size++;
        }

        if (k == size) return head;
        if(k > size) k = k % size;

            int count = 0;
            while(count < k){
                ListNode prev = null;
                 cur = head;

                while(cur.next != null){
                    //prev
                    // 1 -> 2 -> 3 -> 4 -> 5
                    prev = cur; // Reaching the prev last element
                    cur = cur.next; // Reaching the last element;
                }

                cur.next = head;
                prev.next = null;
                count++;
                head = cur;
            }
            return head;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        /*head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/
        final int k = 2000000000;

        /**
         * [1,2,3]
         * 2000000000
         */

        ListNode result = new RotateLinkedList().rotateRight2(head,k);
        System.out.println("");
    }
}
