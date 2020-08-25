class ListNode{
    int val;
    ListNode next;

    //생성자
    ListNode(int x){
        this.val = x;
    }
}

/*
    각 자리수를 더할 때, 결과값이 10을 넘는다면 이것을 다음 자리로 어떻게 올릴 것인가?
    next라는 메소드를 사용 해서 값을 유연하게 저장할 수 있도록 했다.

    next는 재귀함수 같다.

    생성자를 사용했다.

    값 올림은 carry를 사용

    더미데이터를 하나를 만든다.

*/
public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve(ListNode l1, ListNode l2 ){
        //데이터 준비
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = newHead;

        int carry = 0;
        while(p1 != null || p2 != null){
            
            if(p1 != null){
                //캐리값을 준다. 캐리값에 p1을 주고 기존 p1은 날리고 p1.next를 넣는다.
                carry+= p1.val;
                p1 = p1.next
            }
            if(p2 != null){
                //캐리값을 준다. 캐리값에 p1을 주고 기존 p1은 날리고 p1.next를 넣는다.
                carry+= p2.val;
                p2 = p2.next
            }
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
        if(carry ==1 ) p3.next = new ListNode(1);
        return newHead.next;
    }
}