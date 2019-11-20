package leetcode;
//找到最高点，然后向左侧找左侧第二高，最高和第二高之间填满，然后找左侧第三高。。。。向最高点右侧重复
public class S42 {
	 public int trap(int[] height) {
		    if(height.length < 3)
		    	return 0;
	        int heightest = search_heightest_index(height,0,height.length-1);
	        int left_heightest,right_heightest;
	        int left_t = heightest;
	        int right_t = heightest;
	        int area = 0;
	        while(left_t != 0) {
	        	left_heightest = search_heightest_index(height,0,left_t-1);
	        	for(int i = left_heightest+1;i<left_t;i++) {
	        		area+=height[left_heightest] - height[i];
	        		
	        	}
	        	left_t = left_heightest;
	        }
	        
	        
           while(right_t != height.length-1) {
        	   right_heightest = search_heightest_index(height,right_t+1,height.length-1);
        	   for(int i = right_t+1;i<right_heightest;i++) {
	        		area+=height[right_heightest] - height[i];
	        		
	        	}
	        	right_t = right_heightest;
	        }
           
           return area;
	        
	    }
	 
	 public int search_heightest_index(int[] height,int lo,int hi) {
		 int heightest = lo;
	        for(int i = lo + 1;i<=hi;i++) {
	        	heightest = height[i]>height[heightest]?i:heightest;
	        }
	        return heightest;
	 }
}
