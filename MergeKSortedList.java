
public class MergeKSortedList{

    /*

        결과를 해석하여 이미지화 한다.
        약간 지금은 이해하기 어려운 차원이 있다.
        그 차원은 더 깊이 있고 빠르다.

        Comp의 활용, while의 조건문을 깔끔하게 정하기/

    */

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        
        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        MergeKSortedList a = new MergeKSortedList();
        ListNode result = a.mergeKList(list);
        System.out.println("----------")

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] list){
        //Comp 바로 사용
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comp);
        ListNode newHead = new ListNode(0);
        for(ListNode node : lists){
            if(node != null)
                queue.offer(node);
        }

        //while 조건을 이렇게 사용.
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            System.out.print(""+node.val + "\t");
            p.next = node;
            p = p.next;
            if(node.next != null)
                queue.offer(node.next);
        }
        return newHead.next;
    }


    Comparator<ListNode> Comp = new Comparator<ListNode>(){

        @Override
        public int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    }


}

