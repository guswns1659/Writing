package CodesquadCS.LinkedList;

public class Main {
    public static void main(String[] args) {

        VideoInterface vi = new VideoInterface();
        LinkedList linkedList = new LinkedList();

        vi.makeVideo();

        while(true){
            vi.inputCommand(linkedList);
        }
    }
}
