public class SortList {


    public ListNode sort(ListNode head) {

        ListNode cur = head;
        while(cur!= null){
            ListNode p = cur;
            while(p != null){
                // 4 -> 3 -> 2 -> 1
                // next = 3
                // p = 4
                // third = 2
                // next.next = p (4 points to 3)
                // p.next = third (four points to two)

                ListNode next = p.next;
                if(p.next != null) {
                    if (p.value > next.value) {
                        ListNode third = next.next;
                        p.next = third;
                        next.next = p;
                        p = next;
                    }
                }
                p = p.next;
            }
            cur = cur.next;
        }

        System.out.println();
        return null;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        new SortList().sort(head);
        System.out.println("Stop ");
    }
}
