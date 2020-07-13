
import java.util.*;

public class Permutation{
    public static void main(String[] args){
        Permutation object = new Permutation();
        int[] nums = {1,2,3};
        System.out.println(object.permute_dfs(nums));
    }


    public List<List<Integer>> permute_dfs(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        dfs(nums, lists, new ArrayList<Integer>());
        return lists;
    }

    int count = 0;
    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur){
        count++;
        System.out.println("--start--" + cur);

        
    }

}