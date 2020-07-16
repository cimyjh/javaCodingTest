import java.util.*;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

/*

    sort를 해야한다. 
        Collections.sort(intervals, (a,b) -> a.start -b.start)

    compare를 사용할 수도 있다.


    값들의 절대적인 위치가 아닌, 상대적 위치를 잘 사용할 수 있어야 한다.



*/




public class MergeInterval {
    public static void main(String[] args) {
        //int[][] nums = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        Interval in1 = new Interval(1,3);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        MergeInterval a = new MergeInterval();
        List<Interval> list = a.merge(intervals);
        a.print(list);
    }

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;


        //sort
		Collections.sort(intervals, comp2);


        List<Interval> ans = new LinkedList<Interval>();
        Interval hold = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(hold.end >= current.start){
                System.out.println("hold.end: " + hold.end);
                hold.end = Math.max(current.end, hold.end);
            }else{
                System.out.println("22hold.end : " + hold.end);
                ans.add(hold);
                hold = current;
            }
        }
        if(!ans.contains(hold)){
            System.out.println("333hold.end: " + hold.end);
            ans.add(hold);
        }

        return ans;
    }

    Comparator comp = new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }

    };

	Comparator<Interval> comp2 = new Comparator<Interval>() {
		@Override

		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start) {
				return 1;
			} else if (o1.start < o2.start) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	void print(List<Interval> list) {
		for (int i = 0; i < list.size(); i++) {
			Interval in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}


}