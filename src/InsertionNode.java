public class InsertionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //a.next == b.next;

        if (headA == null || headB == null)
            return null;

        if (headA == headB) {
            return headA;
        }

        if (headA.next == headB.next) {
            return headA.next;
        }
        int sizeA = 0;
        int sizeB = 0;
        ListNode curA = headA;
        ListNode curB = headB;


        while (curA.next != null) {
            curA = curA.next;
            sizeA++;
        }
        while (curB.next != null) {
            curB = curB.next;
            sizeB++;
        }

        ListNode pointA = headA;
        ListNode pointB = headB;

        int count = 0;
        int adjust = Math.abs(sizeB - sizeA);


        while (true) {
            if (count == adjust) break;
            if (sizeB > sizeA) {
                pointB = pointB.next;
            } else {
                pointA = pointA.next;
            }

            count++;
        }

        while (true) {

            if (pointA.next == pointB.next) {
                return pointA.next;
            } else {
                pointA = pointA.next;
                pointB = pointB.next;
            }
            if (pointA.next == null || pointB.next == null) {
                return null;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().join();
        System.out.println("no execute ");
        System.exit(0);
        ListNode node = new ListNode(3);



        ListNode sec = new ListNode(2);
        sec.next = node;


        ListNode ret = new InsertionNode().getIntersectionNode(node, sec);
        System.out.println("" + ret.value);
    }
}
