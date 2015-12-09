package lc.dp;

public class DecodeWays {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            if(s.charAt(i-1) != '0') {
                f[i] = f[i-1];//at least f[i] = f[1-1], if (10 <= s.substring(i-1,i) <=26), f[i] += f[i-2];
            }// else , f[i] = 0 temporary
            int previousTwo = Integer.parseInt(s.substring(i-2,i));
            if(previousTwo > 9 && previousTwo < 27) {
                f[i] += f[i-2];
            }
        }
        
        return f[n];
    }
}
