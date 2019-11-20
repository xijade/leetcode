package leetcode;

import java.util.Arrays;
//the lowest cost is smaller between n-1 and n-2, add  cost[n]
public class S746 {
	
	    public int minCostClimbingStairs(int[] cost) {
	    	int len = cost.length;
	    	int[] total_cost = new int[len];
	    	total_cost[0] = cost[0];
	    	total_cost[1] = cost[1];
	    	for(int i =2;i<len;i++) {
	    		total_cost[i] = Math.min(total_cost[i-2]+cost[i], total_cost[i-1]+cost[i]); 
	    	}
	    	System.out.println(Arrays.toString(total_cost));
	    	return Math.min(total_cost[len-2], total_cost[len-1]);
	        
	    }
	
}
