import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_bfs {

    /*

        queue를 LinkedList로 구현
        결과물을 위한 변수 int count

        상하좌우 dirs에 대한 컨트롤.

        이동은 이중for문 가장 안에 bfs 메소드 실행

        bfs는 외워야 한다.


        for문 안에서 0으로 바꾸는 것 같다.



    */


    public static void main(String[] args) {
		char[][] grid= {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'1','0','0','1','1'}
			   };
		NumberOfIslands_bfs a = new NumberOfIslands_bfs();
        System.out.println(a.solve(grid));
        
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(array);

    }
    
    int m, n;

    public int solve(char[][] grid){

        //에러처리 먼저
        if(grid == null ||grid.length == 0)
            return 0;
        
        m = grid.length;
        n = grid[0].length;

        int count = 0;


        //2
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    

    //좌표계를 만들어 둔다.
    int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0,1}};

    public void bfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        Queue<int[]> queue = new LinkedList<>();

        //1차원 배열을 선언하고 0, 1번 째에 x, y의 값을 갖는다.
        queue.offer(new int[]{x,y});


        while(!queue.isEmpty()){
            int size = queue.size();
            int[] p = queue.poll();

            for(int i = 0; i <size; i++){
                for(int[] dir: dirs){

                    //계산하는 좌표계
                    int dx = p[0] + dir[0];
                    int dy = p[1] + dir[1];
                    if(dx>=0 && dx < m && dy>=0 && dy < n && grid[dx][dy] == '1'){
                        grid[dx][dy] = '0';
                        queue.offer(new int[] {dx, dy});
                    }
                }
            }

        }
    }

}