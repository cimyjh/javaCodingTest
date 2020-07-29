import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//강의 제대로 들어야 한다.


/*


    PriorityQueue사용
    원점으로부터 거리가 가까운 것을 결과물로 내는 것이다.

    comp사용한다.


*/

public class KClosest {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        List<Integer> intList = new ArrayList<>();
        List<Integer> intList2 = new ArrayList<>();

        intList.add(1);
        intList.add(3);

        intList2.add(-2);
        intList2.add(2);

        System.out.println(kClosest(list, 1));
    }

    public static int[][] convert(List<List<Integer>> list){
        int[][] array = new int[list.size()][];
        for(int i = 0; i < array.length; i++){
            array[i] = new int[list.get(i).size()];
        }
        for(int i = 0; i <list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                array[i][j] = list.get(i).get(j);
            }
        }
        return array;
    }

    public static int[][] kClosest(List<List<Integer>> list, int K){
        int[][] points = convert(list);
        int N = points.length;
        int[] dists = new int[N];
        for(int i = 0; i < N; ++i) dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for(int i = 0; i < N; ++i){
            if(dist(points[i]) <= distK )
            ans[t++] = points[i];
        return ans;
        }

        public static int dist(int[] point){
            return point[0] * point[0] + point[1] * point[1];
        }
    }



    public int[][] solve(int[][] points, int k){
        Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);

        int[][] result = new int[k][2];
        int index = 0;

        //정렬이 된 것을 queue에 넣는다(offer)
        for(int[] p: points){
            queue.offer(p)
        }

        //여기서 k는 1이니깐 한개만 result에 넣어진다.
        while(index < k){
            result[index] = queue.poll();
            index++
        }

        return result;

    }


    Comparator<int[]> Comp = new Comparator<int[]>(){

        @Override
        public int compare(int[] a, int[] b){

            //a에 대한 오름차순
            return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]);
        }

    }


    
}