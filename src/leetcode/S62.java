package leetcode;
//there m-1+n-1 steps in total,m-1 toward right and n-1 toward down.so to combine C(m-1,m+n-2)
public class S62 {
	 public int uniquePaths(int m, int n) {
	        int total = m+n-2;
	        return comb(m-1,total);
	    }
	 
	 public int comb(int c,int m) {
	    	
	    	long res =1;
	    	if(c>m/2)
	    		c = m-c;
	    	if(c == 0) {
	    		return 1;
	    	}
	    	
	    	for(int i = 0;i<c;i++) {
	    		res = res*(m-i)/(i+1);
	    	}
	    	return (int)res;
	    }
}
