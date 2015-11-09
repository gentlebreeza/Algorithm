package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return rs;
        Arrays.sort(candidates);
        List<Integer> ls = new ArrayList<>();
        addSum(rs, ls, candidates, target, 0);
        return rs;
    }
    
    private void addSum(List<List<Integer>> rs, List<Integer> ls, int[] c, int target, int start) {
        if(target < 0) return;
        if(target == 0) rs.add(new ArrayList<>(ls));
        
        for(int i = start; i < c.length; i++) {
            ls.add(c[i]);
            addSum(rs, ls, c, target-c[i], i);
            ls.remove(ls.size()-1);
        }
    }
}
