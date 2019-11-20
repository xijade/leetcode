package leetcode;

public class S64 {
	 public int minPathSum(int[][] grid) {
	        int n = grid.length;
	        int m = grid[0].length;
	        int[][] cost_min = new int[n][m];
	        cost_min[0][0] = grid[0][0];
	        for(int i = 1;i<n;i++){
	        	cost_min[i][0] = cost_min[i-1][0] + grid[i][0];
	        }
	        
	        for(int j = 1;j<m;j++){
	            cost_min[0][j] = cost_min[0][j-1] + grid[0][j];
	        }
	        
	        
	        for(int i = 1;i<n;i++){
	            for(int j =1;j<m;j++){
	                cost_min[i][j] = Math.min(cost_min[i-1][j],cost_min[i][j-1])+grid[i][j];
	            }
	        }
	        
	        return cost_min[n-1][m-1];
	    }
}
