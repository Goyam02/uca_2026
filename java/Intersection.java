class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}

public class Intersection{

    public static ListNode intersection(ListNode head1, ListNode head2){

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(head1 != null && head2 != null){

            if(head1.val == head2.val){
                tail.next = new ListNode(head1.val);
                tail = tail.next;
                head1 = head1.next;
                head2 = head2.next;
            }
            else if(head1.val < head2.val){
                head1 = head1.next;
            }
            else{
                head2 = head2.next;
            }
        }

        return dummy.next;
    }
}

class Main{
    public static void main(String[] args){

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(6);

        ListNode head2 = new ListNode(2);

        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);

        Intersection obj = new Intersection();

        ListNode result = obj.intersection(head1, head2);
        while(result != null){
            System.out.print(result.val);

            if(result.next != null)
                System.out.print(" -> ");

            result = result.next;
        }





    }
}