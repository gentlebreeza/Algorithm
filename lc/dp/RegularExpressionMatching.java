package lc.dp;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        
        int m = s.length(), n = p.length();
        
        boolean[][] match = new boolean[m+1][n+1];
        
        match[0][0] = true;
        for(int j = 1; j <= n; j++) {
            match[0][j] = (p.charAt(j-1) == '*') && (j-2) >= 0 && match[0][j-2];  
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*') {
                    match[i][j] = match[i][j-2] 
                               || match[i-1][j] && (j-2) >= 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.');
                } else {
                    match[i][j] = match[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
            }
        }
        
        return match[m][n];
    }
}
