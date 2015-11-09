package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rs = new ArrayList<>();
        if(n <= 0 || n < k) return rs;
        List<Integer> ls = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        findCombine(rs, ls, nums, k, 0);
        return rs;
    }
    
    private void findCombine(List<List<Integer>> rs, List<Integer> ls, int[] nums, int k, int pos) {
        if(ls.size() == k) {
            rs.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            // if(ls.contains(nums[i])) continue;
            ls.add(nums[i]);
            findCombine(rs, ls, nums, k, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
