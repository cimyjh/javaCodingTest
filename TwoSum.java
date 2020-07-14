import java.util.*;

//코드만 보고서 이것이 무얼 하는지 모르겠음. 강의를 제대로 들어야 할 듯.


/*
    200714_
        배열의 값 중에서 값들 끼리 합하여  target의 값이 나오도록 하는 것이 목적이다.
        생각 -> 프로그램
        결과를 해석을 해서 이미지화 시킨다.
        한국말을 Java로 변환하는 것이다.

        1. 문제를 정확히 이해
        2. 알고리즘을 정하고 담을 그릇을 정한다
        3. for문 돌리기

        for문 돌리기는 내가 최근에 생각했던 것과 같다.

        10(target)의 값을 배열의 값으로 빼면서 풀어나가야 한다.


        index 0 부터 for돌려, 10 - 2 = 8___ 이 값을 Map에 등록을 한다.(8,1)
        Index를 돌려서 맵에 있는 것과 매치가 되면

*/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,8,11,21};
        int target = 19;
        TwoSum a = new TwoSum();
        int[] result = a.solve(nums, target);
        for(int i : result)
            System.out.println(i);
    }

    public int[] solve(int[] nums, int target){

        //2. 담을 그릇을 설계한다.
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        //3. for문을 먼저 생각해서 설계했다.
        //key값을 확인해 보면서 값들을 일일이 확인 한 것이다.
        for(int i = 0; i < nums.length; i++){
            //map에 값이 있는가? map.containsKey
            if(map.containsKey(nums[i])){
                int mapValue = map.get(nums[i]);
                result[0] = mapValue + 1;
                result[1] = i + 1;
            }else{
                //target - nums[i]
                map.put(target-nums[i], i);
            }
        }
        return result;
        
    }
}