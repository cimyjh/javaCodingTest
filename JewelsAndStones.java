import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(solve(J, S));
    }

    public static int solve(String jew, String stone) {
        //set 선언
        Set<Character> set = new HashSet<>();

        for(char jewel : jew.toCharArray()){
            set.add(jewel);
        }

        int count = 0;
        for(char stoneChar : stone.toCharArray()){
            System.out.println("stoneChar: " + stoneChar);
            if(set.contains(stoneChar)){
                count++;
            }
        }
        return count;
    }
}