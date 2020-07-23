import java.util.HashSet;
import java.util.Set;


/*

    보석은 대소문자를 구분해서 갖고 있어야 한다.
    스톤에서 보석을 비교를 한다.
    스톤에 가서 aA가 몇개 있는지 구분

    set 중복 허용하지 않음
    HashsSet<>() 선언

    set.contain은 내용물이 같은지 확인


*/



public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbAbabba";
        System.out.println(solve(J, S));
    }

    public static int solve(String jew, String stone){

        //담는 그릇
        Set<Character> set = new HashSet<>();

        //jew의 글자를 set에 담는다
        for(char jewel : jew.toCharArray()){
            set.add(jewel);
        }

        int count = 0;
        for(char stoneChar : stone.toCharArray()){
            System.out.println("stoneChar: " + stoneChar);
            //contains 스톤 한 개씩 확인.
            if(set.contains(stoneChar)){
                count++;
            }
        }
        return count;
    }


}