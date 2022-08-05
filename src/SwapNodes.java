import java.util.Stack;

public class SwapNodes {


    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;

        Stack<ListNode> nodeStack = new Stack<>();
        while(cur.next != null){
          ListNode prev = cur;
          cur = cur.next;
          prev.next= null;
          nodeStack.push(prev);
        }
        nodeStack.push(cur);
        ListNode ret = null;
        while(nodeStack.size() != 0){
            if (ret == null){
                ret = new ListNode(nodeStack.pop().value);
            }else {
                ListNode c = ret;
                while(c.next != null){
                    c = c.next;
                }
                c.next = new ListNode(nodeStack.pop().value);
            }


        }

        return ret;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        ListNode ret = reverse(node);
        System.out.println(ret);

    }
}
