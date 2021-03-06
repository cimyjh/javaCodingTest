import java.util.Arrays;
import java.util.Comparator;


//vo 객체 생성 및 생성자 만들기
class Interval{
    int start;
    int end;

    Interval(){
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

//sorting을 먼저 한다.
//hold.end > cur.start

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms a = new MeetingRooms();

        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);
     
        Interval[] intervals = {in1, in2, in3};

        //객체를 메소드의 실행이 되도록 함
        //MVC에서 Service단과 비슷하다.
        System.out.println(a.solve(intervals));
    }


    public boolean solve(Interval[] intervals) {
        //예외처리
        //null 체크
        if(intervals == null) return false;
        print(intervals);

        //Compare해서 sort 하는 것
        Arrays.sort(intervals, Comp);
        System.out.println("===afrer sort ===");
        print(intervals);

        //반복문을 돌려서 조건체크
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i-1].end > intervals[i].start)
            return false;
        }
        return true;
    }

    public void print(Interval[] intervals){
        for(int i = 0; i <intervals.length; i++){
            Interval in = intervals[i];
            System.out.println(in.start + "  " + in.end);
        }
    }

    //크기 비교를 Comparator 사용. Override 과정이 필요하다.
    Comparator<Interval> Comp = new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b){

            //오름차순
            return a.start - b.start;
        }
    };

    
}