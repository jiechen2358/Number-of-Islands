class DfsSolution {
    private char[][] myCopy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        if ((grid == null) || (grid.length == 0))
        {
            return 0;
        }
        int count = 0;
        myCopy = new char[grid.length][];
        for (int i = 0; i < grid.length; i++)
        {
            myCopy[i] = grid[i].clone();
        }
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (myCopy[i][j] == '1')
                {
                    dfs(i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    private void dfs(int x, int y)
    {
        myCopy[x][y] = '0';
        for (int i = 0; i < 4; i++)
        {
            if ((isValid(x + dx[i], y + dy[i])) && (myCopy[x + dx[i]][y + dy[i]] == '1'))
            {
                dfs(x + dx[i], y + dy[i]);
            }
        }
    }
    private boolean isValid(int x, int y)
    {
        if ((x < 0) || (y < 0) || (x >= myCopy.length) || (y >= myCopy[0].length))
        {
            return false;
        }
        return true;
    }
}
