package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums == null || nums.length == 0) return rs;
        List<Integer> ls = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        findUniqPermut(rs, ls, nums, visited);
        return rs;
    }
    
    private void findUniqPermut(List<List<Integer>> rs, List<Integer> ls, int[] nums, boolean[] visited) {
        if(ls.size() == nums.length) {
            rs.add(new ArrayList<Integer>(ls));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || i > 0 && !visited[i-1] && nums[i] == nums[i-1]) {// should be with "!visited[i-1]", think about [1,1]
                continue;
            }
            ls.add(nums[i]);
            visited[i] = true;
            findUniqPermut(rs, ls, nums, visited);
            visited[i] = false;
            ls.remove(ls.size()-1);
        }
    }
}
