package lc.dp;

public class MaxSubarray {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        boolean allNegative = true;
        
        for(int i = 0; i < nums.length; i++) {
            if(allNegative && nums[i] > 0) allNegative = false;
            if(i != 0) {
                sum = Math.max(sum + nums[i], nums[i]);
            } else {
                sum = nums[0];
            }
            max = Math.max(max, sum);
        }
        
        if(allNegative) {
            int maxInNegative = Integer.MIN_VALUE;
            for(int i : nums) {
                maxInNegative = Math.max(i, maxInNegative);
            }
            return maxInNegative;
        }
        
        return max;
    }
}
