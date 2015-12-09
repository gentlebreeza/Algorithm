package lc.dp;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] f = new int[m][n];//f[i][j] means at the time you get on position(i,j), the amount hp you should at least have.
        
        f[m-1][n-1] = dungeon[m-1][n-1] < 0 ? 1 - dungeon[m-1][n-1] : 1;
        for(int i = m-2; i >= 0; i--) {
            f[i][n-1] = Math.max(1, f[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int j = n-2; j >= 0; j--) {
            f[m-1][j] = Math.max(1, f[m-1][j+1] - dungeon[m-1][j]);
        }
        
        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                int moveDown = Math.max(1, f[i+1][j] - dungeon[i][j]);
                int moveRight = Math.max(1, f[i][j+1] - dungeon[i][j]);
                f[i][j] = Math.min(moveDown, moveRight);
            }
        }
        
        return f[0][0];
    }
}
