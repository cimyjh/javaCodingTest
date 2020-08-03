public class MaxSubArray{


    /*

        내가 풀었을 때 간과한 부분은 비교 조건에 대한 것이다.

    */
    
    public static void main(String[] args){
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 15};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){

        int newSum = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++){
            newSum = Math.max(newSum + nums[i], nums[i]);


            max = Math.max(max, newSum);
        }
        return max;
    }

}