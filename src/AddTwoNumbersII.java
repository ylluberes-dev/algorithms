import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        final Stack<ListNode> s1 = new Stack<>();
        final Stack<ListNode> s2 = new Stack<>();

        ListNode cur = l1;
        while (cur != null) {
            s1.push(cur);
            cur = cur.next;
        }

        cur = l2;
        while (cur != null) {
            s2.push(cur);
            cur = cur.next;

        }

        ListNode result = new ListNode();
        ListNode tem = result;
        boolean plusOne = false;
        while(true) {
            int s1Value = 0;
            int s2Value = 0;
            if(!s1.isEmpty()) {
                s1Value = s1.pop().value;
            }
            if(!s2.isEmpty()) {
                s2Value = s2.pop().value;
            }
            int sum = s1Value + s2Value + (plusOne ? 1 : 0);
            if (sum > 9) {
                sum = sum % 10;
                plusOne = true;
            }else {
                plusOne = false;
            }

            result.value = sum;
            if(s1.isEmpty() && s2.isEmpty()) {
                if(plusOne){
                    result.next = new ListNode(1);
                    break;
                }


            }
            result.next = new ListNode();
            result = result.next;
        }
        return reverse(tem);
    }
    static void printLinkedList (final ListNode head) {
        if(head != null){
            ListNode cur = head;
            while(cur != null) {
                System.out.println(cur.value);
                cur = cur.next;
            }
        }
    }

    // 1 -> 2 -> 3
    static ListNode reverse (ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printLinkedList(new AddTwoNumbersII().addTwoNumbers(l1, l2));

        /*int count = 0;
        ListNode test = new ListNode();
        ListNode temp = test;
        while(count < 5) {
            test.value = count;
            test.next = new ListNode(count);
            test = test.next;
            count++;
        }

        System.out.println("");
        System.out.println(temp);*/
    }

}
