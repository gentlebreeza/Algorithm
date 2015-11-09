package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return rs;
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];// similar to permutations II
        List<Integer> ls = new ArrayList<>();
        addSum(rs, ls, candidates, visited, target, 0);
        return rs;
    }
    private void addSum(List<List<Integer>> rs, List<Integer> ls, int[] c, boolean[] visited, int target, int start) {
        if(target < 0) return;
        if(target == 0) rs.add(new ArrayList<>(ls));
        
        for(int i = start; i < c.length; i++) {
            if(i > 0 && !visited[i-1] && c[i] == c[i-1]) continue;
            ls.add(c[i]);
            visited[i] = true;
            addSum(rs, ls, c, visited, target-c[i], i+1);
            visited[i] = false;
            ls.remove(ls.size()-1);
        }
    }
}
