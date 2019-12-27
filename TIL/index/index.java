package index;

import kr.Algorithm.CountingBlob;
import kr.Algorithm.Maze;

public class index {
    public static void main(String[] args) {
        Maze m = new Maze();
//        System.out.println(Maze.findMazePath(0,0));
        CountingBlob b = new CountingBlob();
        System.out.println(b.countBlog(2,4));
    }
}
