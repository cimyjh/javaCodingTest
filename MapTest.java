import java.util.*;


public class MapTest{
    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "d", "a"};
        String[] arr2 = {"a", "b", "w"};

        Map<String, Integer> map_old = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        for(String str : arr){
            if(map_old.containsKey(str)){
                map_old.put(str, map_old.get(str) + 1);
            }else {
                map_old.put(str, 1);
            }
        }
        System.out.println(map_old);

        for(String a : arr) map.put(a, map.getOrDefault(a, 0) + 1);
        System.out.println(map);
    }
}