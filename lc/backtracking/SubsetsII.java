package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums == null || nums.length == 0) return rs;
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums);
        this.helper(nums, rs, ls, 0);
        return rs;
    }
    private void helper(int[] nums, List<List<Integer>> rs, List<Integer> ls, int pos) {
        rs.add(new ArrayList<Integer>(ls));
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            this.helper(nums, rs, ls, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
