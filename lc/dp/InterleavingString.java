package lc.dp;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s2 == null && s1 != null && s3 != null) {
            return s1.equals(s3);
        }
        if(s1 == null && s2 != null && s3 != null) {
            return s2.equals(s3);
        }
        if(s3 == null && s1 != null && s2 != null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length();
        int n = s2.length();
        boolean[][] f = new boolean[m+1][n+1];
        
        f[0][0] = true;
        for(int i = 1; i <= m; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)) {
                f[i][0] = true;
            } else {
                break;
            }
        }
        for(int j = 1; j <= n; j++) {
            if(s2.charAt(j-1) == s3.charAt(j-1)) {
                f[0][j] = true;
            } else {
                break;
            }
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                f[i][j] = f[i-1][j] && (s1.charAt(i-1) == s3.charAt(i-1+j))
                       || f[i][j-1] && (s2.charAt(j-1) == s3.charAt(j-1+i));
            }
        }
        
        return f[m][n];
    }
}
