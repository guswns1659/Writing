package CodesquadCS.LinkedList;

import java.util.Scanner;

public class VideoInterface {

    VideoData[] videoList = new VideoData[13];

    // 비디오 13개 만들고 배열에 넣는 메서드
    public void makeVideo() {
        System.out.println("---영상클립---");
        for (int i = 0; i < 13; i++) {
            VideoData video = new VideoData();
            videoList[i] = video;
            System.out.println(video);
        }
    }

    // 커맨드 입력 메서드
    public void inputCommand(LinkedList linkedList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");

        String[] splitCommands = scanner.nextLine().split(" ");

        String method = splitCommands[0];

        if (method.equals("add")) {
            String videoId = splitCommands[1];
            VideoData newData = findVideo(videoId);
            linkedList.add(newData);
            linkedList.showLinkedList();
        } else if (method.equals("insert")){
            String videoId = splitCommands[1];
            VideoData newData = findVideo(videoId);
            linkedList.insert(newData, Integer.parseInt(splitCommands[2]));
            linkedList.showLinkedList();
        } else if (method.equals("delete")){
            String videoId = splitCommands[1];
            linkedList.delete(videoId);
            linkedList.showLinkedList();
        } else{
            linkedList.render();
        }

    }

    // id값으로 video를 찾는 메서드
    public VideoData findVideo(String videoId) {
        VideoData returnData = null;
        for (int i = 0; i < videoList.length; i++) {
            returnData = videoList[i];
            if (videoId.equals(returnData.getId())) {
                return returnData;
            }
        }
        return returnData;
    }
}
