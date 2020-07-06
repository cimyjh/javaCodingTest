public class NumberOfislands_dfs {

    /*
        Graph문제
        좌우만 있는 것이 아니라 상하좌우가 있다.

        이중 for문으로 상하좌우 이동 가능하다.
        문제에 대한 이해와 이를 관통하는 내용을 이해해야한다.

        상하좌우 dir를 사용할 수 도 있다.


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
    int numsIslands(char[][] grid){
        if(grid == null || grid.length == 0 ||grid[0].length ==0) return 0;
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++ ){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    System.out.println("i: " + i + "y: " + j);
                    merge(grid,i, j);
                }
            }
        }
        return count;
    }

    void merge(char[][] grid, int i, int j){
        System.out.println("=========merge========= i :" + i + " ,y: " + j);
        if(i < 0 || i >= m || j <0 || j >= n || grid[i][j] != '1') return;
        grid[i][j]='X';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j+1);
        merge(grid, i, j-1);
    }
}