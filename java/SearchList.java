class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}

public class SearchList{

    public static String searchList(ListNode list1, ListNode list2){

        if(list1 == null) return "Yes";

        while(list2 != null){

            ListNode temp1 = list1;
            ListNode temp2 = list2;

            while(temp1 != null && temp2 != null && temp1.val == temp2.val){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            if(temp1 == null) return "Yes";

            list2 = list2.next;
        }

        return "No";
    }
}

class Main{
    public static void main(String[] args){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(1);
        list2.next.next.next = new ListNode(2);
        list2.next.next.next.next = new ListNode(3);
        list2.next.next.next.next.next = new ListNode(4);

        SearchList obj = new SearchList();

        String result = obj.searchList(list1, list2);

        System.out.println(result);
    }
}