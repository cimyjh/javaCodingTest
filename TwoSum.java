import java.util.*;

//코드만 보고서 이것이 무얼 하는지 모르겠음. 강의를 제대로 들어야 할 듯.
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,8,11,21};
        int target = 10;
        TwoSum a = new TwoSum();
        int[] result = a.solve(nums, target);
        for(int i : result)
            System.out.println(i);
    }

    public int[] solve(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int mapValue = map.get(nums[i]);
                result[0] = mapValue + 1;
                result[1] = i + 1;
            }else{
                map.put(target-nums[i], i);
            }
        }
        return result;
        
    }
}