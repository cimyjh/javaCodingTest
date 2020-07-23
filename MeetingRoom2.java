import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    sort을 먼저 한다.
    우선순위에 따라 우선순위큐를 사용한다.
    종료시간을 중요하게 생각하자.
    End < start


    queue 
    추가: offer()
    삭제: poll()
    검사: peek()

*/


// vo
class Interval{
    int start, end;
    Interval(){
        this.start = 0;
        this.end = 0;
    }
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class MeetingRoom2 {
    public static void main(String[] args) {
        MeetingRoom2 a = new MeetingRoom2();
        Interval in1 = new Interval(5,10);
        Interval in2 = new Interval(15,20);
        Interval in3 = new Interval(0,30);
        Interval[] intervals = {in1, in2, in3};

        //MVC의 service처럼 사용
        //메소드 호출 및 print
        System.out.println(a.solve(intervals));
    }

    public int solve(Interval[] intervals){

        //예외에 대한 종료 조건
        if(intervals != null || intervals.length == 0)
            return 0;


        //시작값으로 정렬됨
        Arrays.sort(intervals, Comp);

        //그릇에 담음
        Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, Comp2);

        
        for(int i = 1; i < intervals.length; i++){

            //interval에 0번째 큐의 값을 빼서 넣는다.
            //interval의 값을 기준으로 조건문을 돌릴 것이다.
            //interval의 값은 변경될 것이다.
            Interval interval = heap.poll();

            //i번째 큐와 0번째 큐를 비교한다.
            if(interval.end <= intervals[i].start){
                interval.end = intervals[i].end;
            }else{
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();

    }

    Comparator<Interval> Comp = new Comparator<Interval>(){

        @Override
        public int compare(Interval o1, Interval o2){
            return o1.start - o2.start;
        }
    };

    Comparator<Interval> Comp2 = new Comparator<Interval>(){

        @Override
        public int compare(Interval o1, Interval o2){
            return o1.end - o2.end;
        }
    };

}