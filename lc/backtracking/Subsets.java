package lc.backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		if(nums == null || nums.length == 0) return rs;
		List<Integer> ls = new ArrayList<>();
		Arrays.sort(nums);
		addSub(rs, ls, nums, 0);
		return rs;
	}
	
	private void addSub(List<List<Integer>> rs, List<Integer> ls, int[] nums, int start) {
		rs.add(new ArrayList<>(ls));
		for(int i = start; i < nums.length; i++) {
			ls.add(nums[i]);
			addSub(rs, ls, nums, i+1);
			ls.remove(ls.size()-1);
		}
	}
}
