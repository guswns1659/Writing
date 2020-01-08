package CodesquadCS.DataStructure.LinkedList;

import java.util.Random;

public class VideoData {
    private String id;
    private String title;
    private int runningTime;
    private VideoData next = null;
    private VideoData prev = null;

    static int number = 1;

    // LinkedList의 head와 tail 생성자
    public VideoData(int runningTime) {
        this.id = null;
        this.title = null;
        this.runningTime = runningTime;
        this.next = null;
        this.prev = null;
    }

    // Video 만드는 생성자
    public VideoData() {
        this.id = randomId();
        this.title = "제목" + number++;
        this.runningTime = (int) (Math.random() * 15) + 1;
        this.next = null;
        this.prev = null;
    }

    // Video의 id를 random으로 생성하는 메서드
    public String randomId() {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            Random rnd = new Random();
            String randomStr = String.valueOf((char) ((rnd.nextInt(26)) + 97));
            id.append(randomStr);
        }
        return id.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public VideoData getNext() {
        return next;
    }

    public void setNext(VideoData next) {
        this.next = next;
    }

    public VideoData getPrev() {
        return prev;
    }

    public void setPrev(VideoData prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return this.title + "(" + this.id + ") : " + this.runningTime;
    }
}
