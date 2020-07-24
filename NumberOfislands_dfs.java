public class NumberOfislands_dfs {

    /*
        Graph문제
        좌우만 있는 것이 아니라 상하좌우가 있다.

        이중 for문으로 상하좌우 이동 가능하다.
        문제에 대한 이해와 이를 관통하는 내용을 이해해야한다.

        상하좌우 dir를 사용할 수 도 있다.


        문제를 정확하게 이해하고
        알고리즘을 정한다
        담을 그릇을 정한다
        for문을 돌린다.


        결과를 해석하여 이미지화 시킨다.

        DFS는 응용이 무궁무진하다. 


        위치에 대한 이미지가 그려져야 한다.


        와.. 1의 값을 재귀로서 한번만 count++ 하고서 나머지 것들은 1이 아닌  X로 바꾼다.


    */
    public static void main(String[] args){
        char[][] grid = {
            {'1','1','0','0','1'},
            {'1','1','0','0','0'},
            {'0','0','1','1','0'},
            {'1','0','0','1','1'}
        };

        NumberOfislands_dfs a = new NumberOfislands_dfs();
        System.out.println(a.numsIslands(grid));
    }

    int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
    int m, n;

    public int numsIslands(char[][] grid){

        //에러처리
        //가로 세로 모두 예외 처리
        if(grid == null || grid.length == 0 ||grid[0].length ==0) return 0;

        //가로 m , 세로를 가로 한 객체의 길이로 n = m.length 구한다.
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        
        for(int i = 0; i < m; i++ ){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    System.out.println("i: " + i + "y: " + j);
                    dfs(grid,i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j){
        System.out.println("=========merge========= i :" + i + " ,y: " + j);
        if(i < 0 || i >= m || j <0 || j >= n || grid[i][j] != '1') return;


        //여기서 실제로 존재하는 grid의 값을 1에서 X로 바꾼다.
        grid[i][j]='X';

        //여기서 사방으로 돌아야 한다.
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }



}