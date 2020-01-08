package CodesquadCS.DataStructure.LinkedList;

public class LinkedList {
    VideoData head = new VideoData(-1);
    VideoData tail = new VideoData(-1);

    int count = 0;

    // 양방향 연결리스트
    public LinkedList() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    // 1. add
    public void add(VideoData newData) {
        VideoData isOverlap = traverse(newData.getId());
        if (isOverlap == null) {
            insertChangeLink(tail, newData);
        }
    }

    // 2. insert
    public void insert(VideoData newData, int index) {
        VideoData isOverlap = traverse(newData.getId());
        if (isOverlap == null) {
            VideoData pointer = head.getNext();
            if (count < index) {
                add(newData);
            } else {
                for (int i = 1; i < index; ++i) {
                    pointer = pointer.getNext();
                }
                insertChangeLink(pointer, newData);
            }
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

    // 5. traverse
    public VideoData traverse(String id) {
        VideoData pointer = head.getNext();
        while (pointer != tail) {
            if (id.equals(pointer.getId())) {
                System.out.println("중복된 id입니다. 다시 입력해주세요.");
                return pointer;
            } else {
                pointer = pointer.getNext();
            }
        }
        return null;
    }

    // 삽입될 때 링크 조절되는 메서드
    private void insertChangeLink(VideoData pointer, VideoData newData) {
        VideoData preData = pointer.getPrev();
        preData.setNext(newData);
        newData.setPrev(preData);
        newData.setNext(pointer);
        pointer.setPrev(newData);

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

    // 연결리스트를 출력하는 메서드
    public void showLinkedList() {
        VideoData pointer = head.getNext();
        String id;
        int runningTime;

        while (pointer != tail) {
            id = pointer.getId();
            runningTime = pointer.getRunningTime();
            System.out.printf("[%s, %dsec]---", id, runningTime);
            pointer = pointer.getNext();
        }
        System.out.print("[end]\n\n");
    }
}
