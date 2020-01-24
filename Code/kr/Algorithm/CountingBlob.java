package kr.Algorithm;

public class CountingBlob {
    private static int N=8;
    private static int [][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1},
    };

    private static final int BACKGROUND_COLOR = 0;
    private static final int IMAGE_COLOR = 1;
    private static final int ALREADY_COLOR = 2;

    public int countBlog(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return 0;
        } else if (grid[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            grid[x][y] = ALREADY_COLOR;
            return 1 + countBlog(x-1,y-1) + countBlog(x-1, y) +
                    countBlog(x-1,y+1) + countBlog(x, y+1) +
                    countBlog(x+1,y+1) + countBlog(x+1, y) +
                    countBlog(x+1, y-1) + countBlog(x, y-1);
        }
    }
}
