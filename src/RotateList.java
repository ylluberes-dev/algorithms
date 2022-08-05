public class RotateList {


    public ListNode rotateList (ListNode head, int k) {
        if (head == null){
            return null;
        }
        //Assuming it has a least one node
        int size = 1;
        ListNode first = head;
        ListNode cur = head;
        while(cur.next != null){
            size++;
            cur = cur.next;
        }
        return first;
    }

    public static void main (String [] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new RotateList().rotateList(node,2));
        System.out.println("");
    }
}
