package CodesquadCS.LinkedList;
public class LinkedList {
    VideoData head = new VideoData(-1);
    VideoData tail = new VideoData(-1);

    int count = 0;

    public LinkedList() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    // 1. add
    public void add(VideoData newData) {
        insertChangeLink(tail, newData);
    }

    // 2. insert
    public void insert(VideoData newData, int index) {
        VideoData pointer = head;

        if (count < index) {
            add(newData);
        } else {
            for (int i = 0; i < index; ++i) {
                pointer = pointer.getNext();
            }
            insertChangeLink(pointer, newData);
        }
    }

    // 3. delete
    public void delete(String deleteId) {
        VideoData pointer = head;
        while (!deleteId.equals(pointer.getId())) {
            pointer = pointer.getNext();
        }
        deleteChangeLink(pointer);
    }

    // 4. render
    public void render() {
        System.out.printf("영상클립 : %d\n", count);
        VideoData pointer = head;
        int total = 0;
        for (int i = 0; i < count; i++) {
            pointer = pointer.getNext();
            total += pointer.getRunningTime();
        }
        System.out.printf("전체길이 : %dsec\n", total);
    }

    // 삽입될 때 링크 조절되는 메서드
    private void insertChangeLink(VideoData oldData, VideoData newData) {
        VideoData preData = oldData.getPrev();
        preData.setNext(newData);
        newData.setPrev(preData);
        newData.setNext(oldData);
        oldData.setPrev(newData);

        ++count;
    }

    // 삭제될 때 링크 조절되는 메서드
    private void deleteChangeLink(VideoData pointer) {
        VideoData preData = pointer.getPrev();
        VideoData nextData = pointer.getNext();

        preData.setNext(nextData);
        nextData.setPrev(preData);

        --count;
    }

    // 테스트 메서드
    public void showLinkedList() {
        VideoData pointer = head.getNext();
        while (pointer.getRunningTime() != -1) {
            System.out.printf("[%s, %dsec]---", pointer.getId(), pointer.getRunningTime());
            pointer = pointer.getNext();
        }
        System.out.print("[end]\n\n");
    }
}
