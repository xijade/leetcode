package leetcode;

public class S48 {
    public void rotate(int[][] matrix) {
    	int length = matrix.length;
    	//int[] tem = new int[length];
    	int tem;
    	
    	for(int i = 0;i<=length/2-1;i++) {
    		for(int j = i;j<length-1-i;j++) {
    			tem = matrix[i][j];
    			matrix[i][j] = matrix[length-1-j][i];
    			matrix[length-1-j][i] = matrix[length-1-i][length-1-j];
    			matrix[length-1-i][length-1-j] = matrix[j][length-1-i];
    			 matrix[j][length-1-i] = tem;
    			
    		}
    		
    	}
        
    }
}
