package leetcode;

public class S53 {
    public int maxSubArray(int[] nums) {
        int start = 0;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                start = i;
                sum = nums[i];
                break;
            }
        }

        int sum_temp = 0;
        for(int i =start+1;i<nums.length;i++){
            
        }
        
        return 1;
    }
}