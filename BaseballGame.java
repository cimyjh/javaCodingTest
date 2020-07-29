import java.util.Stack;

public class BaseballGame {



    /*

        Stack을 사용해야 한다.


    */

	
	public static void main(String[] args) {
		String[] strs = {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(strs));
    }
    
    public static int calPoints(String[] ops){

        //1 담는 그릇
        Stack<Integer> stack = new Stack<>();


        //2for문 돌리기
        for(String op: ops){
            switch(op){
                default:
                    stack.push(Integer.valueOf(op));
                
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x);
                    stack.push(y);
                    stack.push(x+y);
                    break;
                
                case "D":
                    stack.push(stack.peek() *2);
                    break;
                
                case "C":
                    stack.pop();
                    break;

            }
        }
        int sum = 0;

        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;


    }


}
