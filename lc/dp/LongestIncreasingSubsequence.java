package lc.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int res = 1;
        int[] len = new int[nums.length];
        Arrays.fill(len, 1);
        len[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            res = Math.max(res, len[i]);
        }
        
        return res;
    }
}
