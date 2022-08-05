import java.util.Stack;

public class DecimalValue {

    public int getDecimalValue(ListNode head) {
        Stack<Integer> reversed = new Stack<>();
        int sum = 0;
        ListNode cur = head;

        while(cur != null){
            reversed.push(cur.value);
            cur = cur.next;
        }
        int sizeGrabbed = reversed.size();
        for (int i = 0; i < sizeGrabbed; i++){
            //System.out.print(reversed.pop());
            sum += Math.pow(2,i) * reversed.pop();
        }
        return sum;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);



        System.out.println(new DecimalValue().getDecimalValue(head));
    }
}
