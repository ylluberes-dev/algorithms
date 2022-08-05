
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
       StringBuilder builder = new StringBuilder();
        ListNode node = head;
        while(node != null){

            builder.append(node.value);
            node = node.next;
        }
        StringBuilder reversed = new StringBuilder();
        String original = builder.toString();
        for (int i = original.length()-1; i>= 0; i--){
           reversed.append(original.charAt(i));
        }
        return reversed.toString().equals(original);

       /* ListNode first = head, second = head, temp = null, prev = null;
        boolean isEven = false;

        while (second != null && second.next != null) {
            second = second.next.next;

            temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;

            if (second == null) isEven = true;
        }

        second = prev;
        if (!isEven) first = first.next;
        while (first != null && second != null) {
            if (first.value != second.value) return false;
            first = first.next;
            second = second.next;
        }

        return true;*/
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }
}
