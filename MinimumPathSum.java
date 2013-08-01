/**
 * 
 * @author yaoruhao
 *
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][]cache = new int [grid.length][];
        int width = grid[0].length;
        int height = grid.length;
        for (int i = 0; i < cache.length; i++) {
			cache[i] = new int [grid[i].length];
			for (int j = 0; j < cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
        cache[height - 1][width - 1] = grid[height - 1][width - 1];
        return findMinPath(0, 0, grid, cache);
    }
    
    public int findMinPath(int i, int j, int [][] grid, int [][]cache) {
    	if (cache[i][j] != -1) {
			return cache[i][j];
		}
    	int choice1 = Integer.MAX_VALUE;
    	int choice2 = Integer.MAX_VALUE;
    	if (i < grid.length - 1) {
			choice1 = findMinPath(i + 1, j, grid, cache);
		}
    	if (j < grid[0].length - 1) {
    		choice2 = findMinPath(i, j + 1, grid, cache);
    	}
    	cache[i][j] = Math.max(0, Math.min(choice1, choice2)) + grid[i][j];
    	return cache[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
