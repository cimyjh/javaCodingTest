public class UniquePath {

    /*

        동적 다이나믹 알고리즘
        예전에 백준 풀 때도 이해가 쉽게 되지 않았던 부분이다.
        지도, 상하좌우에 대한 것이다.   
        
        

        Dynamic programing은 재사용으로 보면 된다.



    */
    
    public static void main(String[] args){
        int m = 7, n = 3;
        System.out.println(UniquePaths(m, n));
    }

    public static int UniquePaths(int m, int n){

        //1. 담을 그릇. 컬렉션이 아닌 임의의 map
        Integer[][]map  = new Integer[m][n];

        //2. for문을 돌린다.
        //시작점 부터 가로 세로를 모두 1로 지정한다(색칠한다.)
        for(int i = 0; i < m; i++){
            map[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            map[0][j] = 1;
        }


        //2중 for문
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){

                //더하기를 할 것의 위치를 알면된다. 
                map[i][j] = map[i -1][j] + map[i][j-1];
                System.out.println("map["+i+"]["+j+"] " + map[i][j]);
            }
        }
        return map[m-1][n-1];
    }


}