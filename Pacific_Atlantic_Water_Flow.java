class Solution {
    int m, n;
    int[][] heights;
    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int col = 0; col < n; col++) {
            dfs(0, col, pacific);
            dfs(m - 1, col, atlantic);
        }
        for (int row = 0; row < m; row++) {
            dfs(row, 0, pacific);
            dfs(row, n - 1, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }
    private void dfs(int row, int col, boolean[][] visited) {

        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= m ||
                newCol < 0 || newCol >= n) {
                continue;
            }
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, visited);
            }
        }
    }
}