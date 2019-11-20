package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S52 {
	
	
	
	public int totalNQueens(int n) {
	        boolean[] diag1 = new boolean[2*n];
	        boolean[] diag2 = new boolean[2*n];
	        boolean[] col = new boolean[n];
	        int[] queen = new int[n];
	        int res = 0;
	        
	        return findpos(res,col,0,n,diag1,diag2,queen);
	        
	        
	    }
	 
	 public int findpos(int res,boolean[] col,int deep,int n,boolean[] diag1,boolean[] diag2,int[] queen) {
		 if(deep == n) {
		
			 
			 return ++res;
			 
		 }
		 for(int i = 0;i < n;i++) {
			 if(diag1[deep+i] == true||diag2[deep-i+n] == true||col[i] == true)
				 continue;
			 queen[deep] = i;
			 diag1[deep+i] = true;
			 col[i] = true; 
			 diag2[deep-i+n] = true;
			 res = findpos(res,col,deep+1,n,diag1,diag2,queen);
			 diag1[deep+i] = false;
			 diag2[deep-i+n] = false;
			 col[i] = false;
		 }
		 return res;
	 }
     public static void main(String args[]) {
    	 S52 s = new S52();
    	 
    	 int res = s.totalNQueens(8);
    	 System.out.print(res);
              
     }
}
