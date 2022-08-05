package RemoveLinkedList;

public class LinkedList {


    public Node deleteNodeAt (Node head, int position) {

        if(position == 0) head = head.next;
        int pos = 0;
        Node cur = head;
        while (true){

            pos++;

            if (pos == position){
                break;
            }
            cur = cur.next;

        }
        if(cur.next.next != null){
            cur.next = cur.next.next;
        }else {
            cur.next = null;
        }


        return head;
    }
    public static void main(String[] args) {
        Node node = new Node(11);
        node.next = new Node(9);
        node.next.next = new Node(2);
        node.next.next.next = new Node(9);

        new LinkedList().deleteNodeAt(node,1);
        System.out.println();

    }
}
