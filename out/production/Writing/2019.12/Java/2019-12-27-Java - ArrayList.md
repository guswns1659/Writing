## 목차
- ArrayList
## 핵심
- **제네릭으로 자료형을 정하면 downCasting 안해도 된다.**

## ArrayList
ArrayList는 Array의 단점을 보완한 API다. 길이의 제약이 없기 때문에 훨씬 편리하게 사용할 수 있다. ArrayList는 원래 Object[]로 이루어져 있다. 그래서 원소가 들어갈 때는 upCasting을 하고 꺼내서 사용할 때는 downCasting을 해야 한다.<br>
하지만 <> : generic으로 자료형을 지정하면 Object[]에서 지정한 자료형으로 바뀐다. 그러면 원소를 꺼낼 때 downCasting할 필요가 없다.<br>
만약 제네릭을 사용하지 않으면 코드에 경고창이 뜬다.
```java
    public static void main(String[] args) {
        ArrayList<BookDTO> arr = new ArrayList<>();
        arr.add(new BookDTO("java", 15000, "google"));
        arr.add(new BookDTO("python", 20000, "amazon"));

        for (BookDTO obj : arr) {
            System.out.println(obj.toString());
        }
    }
```

