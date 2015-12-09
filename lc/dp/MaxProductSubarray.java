package lc.dp;

public class MaxProductSubarray {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] large = new int[n];
        int[] small = new int[n];
        large[0] = nums[0];
        small[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++) {
            large[i] = Math.max(Math.max(small[i-1] * nums[i], nums[i]), large[i-1] * nums[i]);
            small[i] = Math.min(Math.min(small[i-1] * nums[i], nums[i]), large[i-1] * nums[i]);
            res = Math.max(large[i], res);
        }
        
        return res;
    }
}
