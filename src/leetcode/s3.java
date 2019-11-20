package leetcode;

public class s3 {
	 public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
			 return 0;
	    char[] a = s.toCharArray();
	    int max_len = 1;
	    int cur_len = 1;
	    int i = 0;
	    int j = 1;
	   for(;j<a.length;j++) {
	    	   
	       for(int k = i;k < j;k++) {
	    	   if(a[k] == a[j]) {
	    		   max_len = (cur_len > max_len)?cur_len:max_len;
                    cur_len = j - k;
	    			i = k+1;
	    			cur_len--;
	    			break;
	    		 }
	    	}
	    	   
	        cur_len++;
	       }
	       return (cur_len > max_len)?cur_len:max_len;
	    }
	 public static void main(String args[]) {
		 String s = "aa";
		 s3 a = new s3();
		 System.out.print(a.lengthOfLongestSubstring(s));
	 }
	 
}
