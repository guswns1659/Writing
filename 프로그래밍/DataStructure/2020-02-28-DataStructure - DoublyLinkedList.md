## 목차
- 연결리스트란?
- 연결리스트 구현 코드   
## 핵심 
- **연결리스트는 배열의 삽입과 삭제를 보완한 자료구조이다.**

## 연결리스트란? 
연결리스트는 각 원소가 포인터로 연결되어 있는 자료구조를 말한다. **왜 태어났을까?** 배열이 가진 단점을 보완하기 위해 등장했다. 배열은 원소의 삽입과 삭제 시 그 뒤에 있는 원소들이 줄줄이 움직여야 한다.<br>
그렇기에 삽입과 삭제시 선형 시간 복잡도를 가진다. 연결리스트는 이런 배열의 단점을 포인터로 극복한다. 각 원소는 메모리에서 따닥따닥 붙어 있지 않다. 각 원소는 이전 혹은 이후 원소의 주소를 참조한다.<br>
주소를 참조하기 때문에 메모리에 따닥따닥 붙어있지 않는다. 그러면 삽입과 삭제의 시간이 단축될까? 그렇다. 삽입과 삭제시 주변 원소의 포인터를 조정해주면 된다. 그러면 상수 시간 복잡도를 가진다. 그런데 삭제는 상황에 따라 다르다. 삭제하려는 노드를 알고 있으면 그 노드를 지우면 상수시간 복잡도다. 하지만 노드가 있는지 없는지 모를 때는 찾는 과정이 필요하기 때문에 선형시간 복잡도이다.  

## 연결리스트 구현 코드  

```java
package selfPractice;

import java.util.Comparator;

public class DoublyLinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> current;

    DoublyLinkedList() {
        head = current = new Node<E>(); // 같다의 의미가 아니라 대입한다는 의미.
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    // 입력한 데이터 검색
    public E search(E data, Comparator<? super E> c) {
        Node<E> ptr = head.next;
        while(ptr != head) {
            if (c.compare(data, ptr.data) == 0) {
                current = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 선택 노드 출력
    public void printCurrentNode() {
        if (isEmpty()) System.out.println("선택 노드가 없습니다.");
        else System.out.println(current.data);
    }

    // 모든 노드 출력
    public void dump() {
        Node<E> ptr = head.next;

        while(ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    // 모든 노드를 거꾸로 출력
    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while(ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 하나 뒤쪽을 이동
    public boolean next() {
        if (isEmpty() || isTail()) {
            return false;
        }
        current = current.next;
        return true;
    }

    private boolean isTail() {
        return current.next == head;
    }

    // 선택 노드를 하나 앞으로 이동
    public boolean prev() {
        if (isEmpty() || isHead()) {
            return false;
        }
        current = current.prev;
        return true;
    }

    private boolean isHead() {
        return current.prev == head;
    }

    // 선택 노드의 바로 뒤에 노드를 삽입
    public void add(E data) {
        Node<E> node = new Node<>(data, current, current.next);
        current.next.prev = node;
        current.next = node;
        current = node;
    }

    // 머리에 노드 삽입
    public void addFirst(E data) {
        current = head;
        add(data);
    }

    // 꼬리에 노드 삽입
    public void addLast(E data) {
        current = head.prev;
        add(data);
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        if (!isEmpty()) {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            current = current.prev;
        }
        if (current == head) current = head.next;
    }

    // 노드 p를 삭제
    public void remove(Node<E> p) {
        Node<E> ptr = head.next;
        while(ptr != head) {
            if (ptr == p) {
                current = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        current = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        current = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제
    public void clear() {
        while(!isEmpty()) {
            removeFirst();
        }
    }
}
```
