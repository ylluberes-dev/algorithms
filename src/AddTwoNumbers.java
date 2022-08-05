import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode aCur = l1;
            ListNode bCur = l2;

            StringBuilder aBuilder = new StringBuilder();
            StringBuilder bBuilder = new StringBuilder();

            while (aCur != null) {
                aBuilder.append(aCur.value);
                aCur = aCur.next;
            }

            while (bCur != null) {
                bBuilder.append(bCur.value);
                bCur = bCur.next;
            }


            aBuilder.reverse();
            bBuilder.reverse();
            StringBuilder ret = new StringBuilder(String.valueOf(Integer.parseInt(aBuilder.toString()) + Integer.parseInt(bBuilder.toString())));
            ret.reverse();
            ListNode linkedResult = null;
            for (int i = 0; i < ret.length(); i++) {
               linkedResult =  add(linkedResult,Integer.parseInt(String.valueOf(ret.charAt(i))));
            }
            return linkedResult;
    }

    public ListNode add(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = new ListNode(val);
        }
        return head;
    }


    public static void main(String[] args) {
        /*ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode other = new ListNode(5);
        other.next = new ListNode(6);
        other.next.next = new ListNode(4);

        new AddTwoNumbers().addTwoNumbers(head,other);*/


        List<String> sample = Arrays.asList(new String []{"hola","adios"});
        print(sample);
        System.out.println();
        System.out.println("After join");
        String a = sample.stream().collect(Collectors.joining(","));
        print(a);
    }

    private static void print (final List<String> values) {
        values.stream().forEach(
                value -> System.out.print(value +" " )
        );
    }

    private static void print (final String out) {
        System.out.println(out);
    }
}
