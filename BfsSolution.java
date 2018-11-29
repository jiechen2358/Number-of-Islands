class BfsSolution {
    private char[][] myCopy = null;
    private int sizeX = 0;
    private int sizeY = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        if ((grid == null) || (grid.length == 0))
        {
            return 0;
        }
        int result = 0;
        myCopy = new char[grid.length][];
        for (int i = 0; i < grid.length; i++)
        {
            myCopy[i] = grid[i].clone();
        }
        sizeX = myCopy.length;
        sizeY = myCopy[0].length;
        for (int i = 0; i < sizeX; i++)
        {
            for (int j = 0; j < sizeY; j++)
            {
                if (myCopy[i][j] == '1')
                {
                    bfs(i, j);
                    result += 1;
                }
            }
        }
        return result;
    }
    private void bfs(int x, int y)
    {
        Queue<Integer> visit = new LinkedList<>();
        visit.add(x * sizeY + y);
        myCopy[x][y] = '0';
        while (!visit.isEmpty())
        {
            Integer node = visit.remove();
            int nodeX = node/sizeY;
            int nodeY = node%sizeY;
            for (int i = 0; i < 4; i++)
            {
                if ((isValid(nodeX + dx[i], nodeY + dy[i])) && (myCopy[nodeX + dx[i]][nodeY + dy[i]] == '1'))
                {
                    visit.add((nodeX + dx[i]) * sizeY + nodeY + dy[i]);
                    myCopy[nodeX + dx[i]][nodeY + dy[i]] = '0';
                }
            }
        }
    }
    private boolean isValid(int x, int y)
    {
        if ((x < 0) || (x >= sizeX) || (y < 0) || (y >= sizeY))
        {
            return false;
        }
        return true;
    }
}
