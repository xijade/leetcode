package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S51 {
	
	
	
	 public List<List<String>> solveNQueens(int n) {
	        boolean[] diag1 = new boolean[2*n];
	        boolean[] diag2 = new boolean[2*n];
	        boolean[] col = new boolean[n];
	        int[] queen = new int[n];
	        List<List<String>> res = new ArrayList<List<String>>();
	        
	        findpos(res,col,0,n,diag1,diag2,queen);
	        return res;
	        
	    }
	 //回溯参数中必有一个几率解空间res  ,记录每个步骤状态
	 public void findpos(List<List<String>> res,boolean[] col,int deep,int n,boolean[] diag1,boolean[] diag2,int[] queen) {
		 if(deep == n) {
		
			 List<String> t = new ArrayList<String>();
			 char[] tem = new char[n];
			 for(int i = 0;i<n;i++) {
				 
				 for(int j = 0;j<n;j++) {
					 if(j == queen[i]) {
						 tem[j] = 'Q';
					 }else {
						 tem[j] = '.';
					 }
				 }
				 String s =new String(tem);
				 t.add(s);
			 }
			 res.add(t);
			 for(String q:t) {
				 System.out.println(q);
			 }
			 System.out.println();
			 return;
			 
		 }
		 for(int i = 0;i < n;i++) {
			 if(diag1[deep+i] == true||diag2[deep-i+n] == true||col[i] == true)
				 continue;
			 queen[deep] = i;
			 diag1[deep+i] = true;
			 col[i] = true; 
			 diag2[deep-i+n] = true;
			 findpos(res,col,deep+1,n,diag1,diag2,queen);//若得到解则计入解空间，否则for循环直接n个continue结束
			 diag1[deep+i] = false;
			 diag2[deep-i+n] = false;
			 col[i] = false;
		 }
	 }
     public static void main(String args[]) {
    	 S51 s = new S51();
    	 
    	 List<List<String>> res = s.solveNQueens(16);
              
     }
}
