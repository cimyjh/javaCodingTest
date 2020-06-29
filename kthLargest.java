import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    우선순위 큐_ProrityQueue를 사용했다.
    문제 자체가 이해되지 않았다.
    이해를 하고자 노력은 했다.
*/


public class kthLargest {
    
    public static void main(String[] args){
        kthLargest a = new kthLargest();
		int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(a.solve(nums, k));
        System.out.println(a.solve_pq(nums, k));
    }

    private int solve(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        print(nums);
        return nums[n-k];
    }

    public void print(int[] nums){
        for(int i: nums)
            System.out.println("i " + i);
    }

    public int solve_pq(int[] nums,  int k ){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> a-b);

        for(int val : nums){
            pq.offer(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    Comparator<Integer> Comp = new Comparator<Integer>() {

        @Override
        public int compare(Integer a, Integer b){
            return a- b;
        }
    };
}