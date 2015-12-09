package lc.dp;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    f[i][j] = f[i-1][j] + triangle.get(i).get(j);
                }else if (j == i) {
                    f[i][j] = f[i-1][j-1] + triangle.get(i).get(j);
                }else {
                    f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        
        int rs = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            rs = Math.min(rs, f[n-1][j]);
        }
        return rs;
    }
}
