package leetcode;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class S56 {
	public class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
		 }
	
	    public List<Interval> merge(List<Interval> intervals) {
	    	if(intervals.size() <= 1)
	    		return intervals;
	    	List<Interval> res = new ArrayList<Interval>();
	    	
	    	quicksort(intervals);
	    	
	        int len = intervals.size();
	        
	        Interval tem = intervals.get(0);
	        for(int i = 1;i<len;i++) {
	        	Interval comp = intervals.get(i);
	        	if(tem.end < comp.start) {
	        		res.add(tem);
	        		tem = comp;
	        		if(i == len-1)
	        			res.add(tem);
	        	}else {
	        		tem.end = Math.max(tem.end, comp.end);
	        		if(i == len-1)
	        			res.add(tem);
	        	}
	        }
	        return res;
	        
	    }
	    
	    
	    public void quicksort(List<Interval> intervals){
	    	Collections.shuffle(intervals);
	    	
        	quicksort(intervals,0,intervals.size()-1);
	    	
	    	
	    }
	    
	    
	    public void quicksort(List<Interval> intervals,int l,int h){
	    	if (h <= l) {
				return;
			}
	    	int m = sort(intervals,l,h);
	    	quicksort(intervals,l,m-1);
	    
	    	quicksort(intervals,m+1,h);
	    	
	    	
	    	
	    }
	    
        public int sort(List<Interval> intervals,int l,int h){
	    	Interval a = intervals.get(l);
	    	int i = l;
	    	int j = h+1;
	    	
	    	while(true) {
		    	while(intervals.get(++i).start <= a.start) {
		    		if(i == h)
		    			break;
		    	}
		    	    
		    	
		    	while(intervals.get(--j).start >= a.start) {
		    		if( j == l)
		    			break;
		    	}
		    	if(i < j) {
		    	    Collections.swap(intervals, i, j);
		    	   
		    	}else {
		    	    Collections.swap(intervals, l,j);
		    	    break;
		    	}
	    	}
	    
	    	
	    return j;
	    }
        
        public static void main(String args[]) {
        	List<Interval> res = new ArrayList<Interval>();
        	S56 s = new S56();
        	Interval a = s.new Interval(2,6);
        	Interval b = s.new Interval(1,3);
        	Interval c = s.new Interval(8,10);
        	Interval d = s.new Interval(15,18);
        	res.add(a);
        	res.add(b);
         	res.add(d);
        	res.add(c);
        	res = s.merge(res);
        	System.out.println();
        	for(Interval i:res) {
        		System.out.println(i.start+ " " + i.end);
        	}
        	
        	
        }
	    	
	

}
