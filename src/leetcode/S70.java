package leetcode;

public class S70 {
	 public int climbStairs(int n) {
	        int tag = 2 -(n&1);
	        int start = (n+tag)>>1;
	        int res = 1-(n&1);
	        for(;tag<=n;tag+=2,start+=1) {
	        	System.out.println(tag+" " +start);
	        	res += comb(tag,start);
	        }
	        return res;
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
    
    public static void main(String args[]) {
    	S70 s = new S70();
    	System.out.println(s.climbStairs(8));
    }
}
