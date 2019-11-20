package leetcode;

import java.util.List;
import java.util.ArrayList;

public class S57 {
	public class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
	
	
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	      
		 List<Interval> res = new ArrayList<Interval>();
		 int len = intervals.size();
		 if(len == 0)
			 res.add(newInterval);
		 for(int i = 0; i < len ;i++) {
			 Interval t = intervals.get(i);
			 
			 if(t.start > newInterval.end) {
				 res.add(newInterval);
				 for(int j =i;j<len;j++) {
					 res.add(intervals.get(j));
					 
				 }
				 break;
			 }else if(t.end < newInterval.start) {
				 
				 res.add(t);
				 if( i == len-1)
					 
					res.add(newInterval);
			 }else {
				 newInterval.start = Math.min(t.start, newInterval.start);
				 newInterval.end = Math.max(t.end, newInterval.end);
				 if( i == len-1)
					 res.add(newInterval);
				 
			 }
			 
		 }
		 
		 
		 
	   return res;
		 
	  }
}
