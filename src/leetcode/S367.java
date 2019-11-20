package leetcode;

public class S367 {
	 public boolean isPerfectSquare(int num) {
	        int lo = 1;
	        int hi = num;
	        int m = num/2;
	        int cmp;
	        while(lo <= hi){
	            cmp = m - num/m;
	            System.out.println(lo);
	            System.out.println(hi);
	            System.out.println(m);
	            System.out.println(m*m);
	            if(cmp >0){
	                hi = m-1;
	            }else if(cmp < 0){
	                lo = m+1;  
	            }else{
	            	 System.out.println(m*m);
	                if(m*m == num)
	                    return true;
	                else if(m*m <num)
	                    lo = m+1;
	                else
	                    hi = m-1;
	            }
	            
	            m = lo + (hi - lo)/2;
	        }
	        return false;
	    }
	 
	 
	 public static void main(String args[]) {
		 S367 s = new S367();
		 System.out.println(s.isPerfectSquare(9));
	 } 
}
