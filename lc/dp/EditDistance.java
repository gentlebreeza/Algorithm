package lc.dp;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        if(w1 == 0 && w2 == 0) return 0;
        if(w1 == 0 || w2 == 0) return w1 == 0 ? w2 : w1;
        
        int[][] rs = new int[w1+1][w2+1];
        rs[0][0] = 0;
        for(int i = 1; i <= w1; i++) {
            rs[i][0] = i;
        }
        for(int j = 1; j <= w2; j++) {
            rs[0][j] = j;
        }
        for(int i = 1; i <= w1; i++) {
            for(int j = 1; j <= w2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    rs[i][j] = rs[i-1][j-1];
                } else {
                    rs[i][j] = Math.min(Math.min(rs[i][j-1], rs[i-1][j]), rs[i-1][j-1]) + 1;
                }
            }
        }
        return rs[w1][w2];
    }
}
