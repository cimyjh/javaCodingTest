public class GenerateParentheses {
    

    public static void main(String[] args){
        GenerateParentheses object = new GenerateParentheses();
        System.out.println(object.generateParenthesis_dfs(3));
    }

    int count = 0;
    public List<String> generateParenthesis_dfs(int n){
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n, "");
        return result;
    } 

    private void dfs(List<String> result, String str, int left, int right){
        count++;

        if(left < 0 || left > right){
            return;
        }

        if(left == 0 && right == 0){
            result.add(str);
            return;
        }

        dfs(result, str + '(', left -1, right);
        dfs(result, str + ')', left, right - 1);
    }
}