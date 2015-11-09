package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums == null || nums.length == 0) return rs;
        List<Integer> ls = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        findPermutations(rs, ls, nums, visited);
        return rs;
    }
    
    private void findPermutations(List<List<Integer>> rs, List<Integer> ls, int[] nums, boolean[] visited) {
        if(ls.size() == nums.length) {
            rs.add(new ArrayList<Integer>(ls));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            ls.add(nums[i]);
            visited[i] = true;
            findPermutations(rs, ls, nums, visited);
            visited[i] = false;
            ls.remove(ls.size()-1);
        }
    }
}
