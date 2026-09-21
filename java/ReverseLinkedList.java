class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}


public class ReverseLinkedList{

    public static ListNode reverseLin(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode newHead = reverseLin(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;


    }

}

class Main{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList obj = new ReverseLinkedList();

        head = obj.reverseLin(head);
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.val);

            if(temp.next != null)
                System.out.print(" -> ");

            temp = temp.next;
        }


    }
}