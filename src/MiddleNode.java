public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        int elements = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            elements++;
        }

        ListNode pointer = head;
        int count = 0;
        if(elements %2 !=0){
            while(count < (elements / 2)){
                pointer = pointer.next;
                count++;
            }
            return pointer;
        }else {
            while(count < (elements / 2)){
                pointer = pointer.next;
                count++;
            }
            return pointer;

        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(new MiddleNode().middleNode(head));

    }
}