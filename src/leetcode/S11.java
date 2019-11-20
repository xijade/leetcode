package leetcode;

public class S11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int area;
        int max_area = 0;
        while(i < j) {
        	if(height[i] < height[j]) {
        		area = height[i]*(j - i);
        		i++;
        	}else {
        		area = height[j]*(j - i);
        		j--;
        	}
        	
        	max_area = area > max_area?area:max_area;
        }
        return max_area;
    }
}
