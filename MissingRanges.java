import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args){
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(solve(nums, lower, upper));
    }

    /*
    List 초기화
    예외처리___배열이 0 처리
    0부터 배열 [0]값, 배열 마지막 값 부터 배열[끝] 값
    */

    public static List<String> solve(int[] nums, int lower, int upper){
        List<String> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            result.add(showRange(lower, upper));
            return result;
        }

        if(lower < nums[0]){
            result.add(showRange(lower, nums[0]));
        }

        for(int i = 0; i < nums.length - 1; i++){
            //if문으로 예외처리를 한다.
            //이동 범위를 if문을 통해 구현
            if(nums[i] != nums[i + 1] && nums[i] + 1 < nums[i+1]){
                result.add(showRange(nums[i] + 1, nums[i+1] - 1));
            }
        }
    
        if(nums[nums.length - 1] < upper){
            result.add(showRange(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    public static String showRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + " --> " + high);
    }
}