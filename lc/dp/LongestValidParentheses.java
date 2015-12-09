package lc.dp;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[] f = new int[n];
        int max = 0;
        f[0] = 0;
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    f[i] = i > 2 ? f[i-2] + 2 : 2;
                    max = Math.max(max, f[i]);
                } else {// s(i-1) != '('
                    if(i-f[i-1]-1 >= 0 && s.charAt(i-f[i-1]-1) == '(') {
                        f[i] = 2 + f[i-1];
                        if(i-f[i-1]-2 >= 0) {
                            f[i] += f[i-f[i-1]-2];
                        }
                        max = Math.max(max, f[i]);
                    }
                }
            }
        }
        
        return max;
    }
}
