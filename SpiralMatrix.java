import java.util.*;

public class SpiralMatrix{
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(solve(matrix));
    }

    public static List<Integer> solve(int[][] matrix){

        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;

        //변수에 대한 설정 잘 해야 한다.
        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        //반복 조건문 설정
        while(rowStart <= rowEnd && colStart <= colEnd){
            
            //right
            for(int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i])
            }
            rowStart++;

            //down
            for(int i = rowStart; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            //left 3 -> 0
            if(rowStart <= rowEnd){
                for(int i = colEnd; i >= colStart; i--){
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colStart <= colEnd){
                if(rowStart <= rowEnd){
                    for(int i = rowEnd; i >= rowStart; i--){
                        result.add(matrix[i][colStart]);
                    }
                }
            }
        }
    }
}