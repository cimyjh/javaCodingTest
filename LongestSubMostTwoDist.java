import java.util.HashMap;
import java.util.Map;

/*

    하나의 같은 알파벳의 시작과 끝, 길이가 있어야 한다.
    조건문으로 분기해야 한다.

    그리고 2개의 알파벳 길이를 갖고 있어야 한다.

    Map:
        put: 넣기
        getOrDefault: 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.


*/

public class LongestSubMostTwoDist{
    public static void main(String[] args) {
        String s = "ccafhauphdafhoufhausabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

    }

    public static int lengthOfLongestSubstringTwoDistinct(String s){

        //1. 담을 그릇, Map으로 문자열의 길이를 관리한다.
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        
        //커서
        int end = 0;

        //값 2개를 초과하지 못하도록 하는 것이다.
        int counter = 0;
        int len = 0;

        //2. 조건문
        while(end <s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;
            end++;
            while(counter > 2){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }


}