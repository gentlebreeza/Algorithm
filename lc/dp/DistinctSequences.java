package lc.dp;

public class DistinctSequences {
	public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0) return 0;
        if(t.length() == 0) return 1;
        
        int m = s.length();
        int n = t.length();
        int[][] rs = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++) {
            rs[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                rs[i][j] = rs[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)) rs[i][j] += rs[i-1][j-1];
            }
        }
        
        return rs[m][n];
    }
}
