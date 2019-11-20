package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15 {
    public List<List<Integer>> threeSum(int[] nums) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length < 3)
    		return res;
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
    	int pre_i = nums[0] + 1;
    	int pre_j; 
    	int cur_i;
    	for(int i = 0;i < nums.length - 2;i++) {
    		cur_i = nums[i];
    		if(cur_i == pre_i)
    			continue;
    		pre_j = nums[0] - 1; //nums[0] is smallest,so pre_j isn't equal any j;
    		int j = i + 1;
    		int k = nums.length - 1;
    		int tar = -cur_i;
    		while(j < k) {
    			
    			int sum = nums[j] + nums[k];
    			if(sum < tar)
    				j++;
    			else if(sum > tar)
    				k--;
    			else {
    				if(nums[j] != pre_j) {
                        System.out.println(pre_j +" " +j);
	    				List<Integer> t = new ArrayList<Integer>();
	    				t.add(nums[i]);
	    				t.add(nums[j]);
	    				t.add(nums[k]);
	    				
	    				res.add(t);
	    				
	    				pre_j = nums[j];
    				}
    				j++;
    				k--;
    			}
    		}
    		pre_i = cur_i;
    		
    	}
        return res;    
    }
    
    public static void main(String args[]) {
    	int[] a= new int[]{-2,0,0,2,2};
    	S15 s = new S15();
    	
    	System.out.println(s.threeSum(a));
    }
}
