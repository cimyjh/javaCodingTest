import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist{
    public static void main(String[] args) {
        String s = "ccafhauphdafhoufhausabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

    }

    public static int lengthOfLongestSubstringTwoDistinct(String s){
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int counter = 0;
        int len = 0;

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