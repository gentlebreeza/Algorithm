package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rs = new ArrayList<>();
        if(n <= 0 || k <= 0) return rs;
        List<Integer> ls = new ArrayList<>();
        addSum(rs, ls, 1, k, n);
        return rs;
    }
    
    private void addSum(List<List<Integer>> rs, List<Integer> ls, int start, int k, int sum) {
        if(ls.size() == k) {
            if(sum == 0) {
                rs.add(new ArrayList<>(ls));
            }
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            if(ls.contains(i)) continue;
            ls.add(i);
            addSum(rs, ls, i+1, k, sum-i);
            ls.remove(ls.size()-1);
        }
    }
}
