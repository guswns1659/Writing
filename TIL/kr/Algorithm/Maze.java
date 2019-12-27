package kr.Algorithm;
/*
재귀적 사고
1. 현재 좌표가 출구거나
2. 현재 좌표 주변 셀(동,서,남,북)에서 현재 좌표를 지나지 않고 출구로 가는 길이 있는지
 */

public class Maze {
    private static int N=8;
    private static int [][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0},
    };
    private static final int PATHWAY_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;

    public static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N ) {
            return false;
        } else if (maze[x][y] != PATHWAY_COLOR) {
            return false;
        } else if (x == N-1 && y == N-1) {
            return true;
        } else {
            maze[x][y] = PATH_COLOR;
            if (findMazePath(x-1, y) || findMazePath(x,y+1) ||
                findMazePath(x+1, y) || findMazePath(x, y-1)) {
                return true;
            }
            maze[x][y] = BLOCKED_COLOR;
            return false;
        }
    }

}
