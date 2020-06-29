
public class TrappingRainWater{

/*

인강 필수이다.
이동과 계산을 따로 구분하여 구현

물은 좌우 사이에 result 쌓인다.

이동에 대한 것
1회 센싱시 좌 우 필요.

좌, 우: 배열.height길이 
시작: int[1] 부터 시작, 우는 int[3]___
종료: 우 = 배열.height
for each : 좌, 우 +1

필요한 추가 변수
int max, 초기값은 주어진 배열의 0번째 값

결과값을 중첩하여 내는 과정
 - 중간 저장된 max값과 비교해야 한다. 
 - 나는 3개를 기준으로 하려고 했지만 이건 유연하지 못하다.
 - 

좌2, 우 1, --> result = 1;

좌0, 우3, -->
*/

    public static void main(String[] args){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
    public static int trap(int[] nums){
        int result = 0;
        if(nums == null || nums.length <= 2)
            return result;
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int max = nums[0];
        left[0] = nums[0];


        //max를 구하는 것
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < max){
                left[i] = max;
            }else{
                left[i] = nums[i];
                max = nums[i];
            }
        }

        max = nums[nums.length - 1];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < max){
                right[i] = max;
            }else{
                right[i] = nums[i];
                max = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            result += Math.min(left[i], right[i]) - nums[i];
        }
        return result;
    }
}