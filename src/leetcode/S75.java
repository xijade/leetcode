package leetcode;

import java.util.Arrays;

public class S75 {
    public void sortColors(int[] nums) {
    	
        quick3way(nums,0,nums.length-1);
    }



    public void quick3way(int[] nums,int lo,int hi) {
    	if(hi<= lo)
    		return;
    	int lt = lo;
    	int gt = hi;
    	int k = nums[0];
    	int i = lo+1;
    	int tem;
    	while(i <= gt) {
    		int cmp = nums[i] - k;
    		if(cmp < 0) {
    			tem = nums[i];
    			nums[i] = nums[lt];
    			nums[lt] = tem;
    			
    			++i;
    			++lt;
    		}else if(cmp > 0) {
    			tem = nums[i];
    			nums[i] = nums[gt];
    			nums[gt] = tem;
    			gt--;
    		}else {
    			++i;
    		}
    	}
    	
    	quick3way(nums,lo,lt-1);
    	quick3way(nums,gt+1,hi);
    }
    
    public static void main(String args[]) {
    	int[] nums = new int[] {2,0,2,1,1,0};
    	S75 s = new S75();
    	s.sortColors(nums);
    	
    	System.out.print(Arrays.toString(nums));
    	
    	
    }

}
