package lc.backtracking;

import java.util.List;
import java.util.ArrayList;

public class GenerateParenthesis {
	public List<String> generate(int n) {
		List<String> rs = new ArrayList<>();
		if(n <= 0) return rs;
		addParen(rs, "", n, n);
		return rs;
	}
	
	private void addParen(List<String> rs, String p, int left, int right) {
		if(left == 0 && right == 0) {
			rs.add(p);
			return;
		}
		
		if(left > 0) {
			addParen(rs, p+"(", left-1, right);
		}
		if(right > left) {
			addParen(rs, p+")", left, right-1);
		}
	}
}
