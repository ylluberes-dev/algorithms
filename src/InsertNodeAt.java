public class InsertNodeAt {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        if (position == 0){
            SinglyLinkedListNode first = new SinglyLinkedListNode(data);
            first.next = head;
            return head;
        }
        SinglyLinkedListNode cur = head;

        for (int i = 1; i < position; i++) {
            cur = cur.next;
        }
        SinglyLinkedListNode next = cur.next;
        cur.next = new SinglyLinkedListNode(data);
        cur.next.next = next;


        return head;
    }


    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
       // head.next.next.next = new SinglyLinkedListNode(4);
       SinglyLinkedListNode ret = InsertNodeAt.insertNodeAtPosition(head,4,3);
        System.out.println("a");
    }
}