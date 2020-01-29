## 목차

## 핵심
- 

## Stream과 I.O Stream의 차이는?
map, reduce를 제공하는 Stream은 배열, 컬렉션에 담긴 데이터를 가공할 때 사용한다. 하지만 I.O Stream은 데이터를 입력받고 출력할 때 사용한다. 자바는 입출력 대상에 상관없이 동일한 방법으로 입출력을 진행할 수 있도록 I/O모델을 정의했다. 정확히 표현하자면 입출력 대상에 따른 입출력을 돕는 인스턴스는 다르지만 이들의 메서드는 똑같다. ex) read, write ...

## Stream이란?
스트림을 데이터의 이동 통로이다. close()를 하는 이유는 스트림에 할당된 자원을 반환하는 용도이다. 그리고 입력이나 출력이 끝났는 그 통로를 그대로 둘 필요가 없다.
기본적인 데이터의 입출력 단위는 바이트이고, 바이트 단위로 데이터를 입력 및 출력하는 스트림을 가리켜 '바이트 스트림'이라 한다. 왜 바이트일까? 생각해보면 컴퓨터의 모든 프로그램은 0과1로 이루어진 이진수이다. 그렇기 때문에 아무리 한글로 써있다고 해도 0과1로 바뀐다. 그래서 데이터의 기본 입출력 단위가 숫자인 바이트이다.

## try-with-resources문
보다 안정적인 close 메서드의 호출이 보장된다.

```java
public class Write7ToFile3 {
    public static void main(String[] args) {
        output();
        input();
    }

    private static void input() {
        try (InputStream in = new FileInputStream("data.dat")){
            int dat = in.read();
            System.out.println(dat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output() {
        try(OutputStream out = new FileOutputStream("data.dat")) {
            out.write(7);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


## FileInputStream, FileOutputStream의 read()와 write()
- read()는 파일로부터 읽어 들인 1바이트 유요한 데이터에 3바이트의 0을 채워서 4바이트 int형 데이터로 반환한다. 반면 스트림의 끝에 도달해서 더 이상 읽어 들일 데이터가 없는 경우 -1을 반환한다.
- write()는 인자로 전달되는 int형 데이터의 첫 번째 바이트만을 파일에 저장한다.

```java
// kilobyte로 읽고 복사하는 예제
public class BytesFileCopier {
    public static void main(String[] args) {
        copyPaste();
    }

    private static void copyPaste() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원본 파일 : ");
        String source = scanner.nextLine();

        System.out.print("복사 파일 : ");
        String destination = scanner.nextLine();

        try(InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination)){
            byte[] buf = new byte[1024];
            int len;

            while (true) {
                len = in.read(buf);
                if(len == -1) {
                    break;
                }
                out.write(buf, 0, len);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

```

## 필터스트림
필터스트림은 이전에 본 FileInputStream과는 다르게 기능을 보조하는 성격의 스트림이다. 우리는 지금까지 4byte 단위로 파일을 읽을 수 있지만 4byte인 int형 자료형을 사용하진 못한다. 필터 스트림인 4바이트를 읽더라도 int형으로 바꿔주는 역할을 한다. 말그대로 입력하고 출력하는 데이터를 필터로 걸러낸다.

```java
public class DataFilterOuputStream {
    public static void main(String[] args) {
        outputFilterStream();
        inputFilterStream();
    }

    private static void outputFilterStream() {
        try(DataOutputStream out
                    = new DataOutputStream(new FileOutputStream("data.md"))){
            out.writeInt(370);
            out.writeDouble(370.123);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputFilterStream() {
        try(DataInputStream in
                    = new DataInputStream(new FileInputStream("data.md"))){
            int num = in.readInt();
            double num2 = in.readDouble();

            System.out.println(num);
            System.out.println(num2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

### 퍼버링 기능을 제공하는 필터 스트림
필터 스트림 중에서 상대적으로 사용 빈도수가 높은 두 필터 스트림은 BufferedInputStream, BufferedOutputStream이다. 버퍼 스트림은 기본적으로 1byte씩 데이터를 입력하고 출력한다. 하지만 기본 입력, 출력 스트림보다 속도가 빠르다. 이유는 바로 내부에 버퍼(메모리 공간)을 가지고 있기 때문이다.<br>
버퍼는 마치 트럭과 같아서 입력을 받을 때 파일로 매번 접근하는 것이 아니라 트럭 한대를 끌고 가서 트럭 크기 만큼 받아온다. 받아 온 뒤 1byte씩 데이터를 읽는다. 이게 왜 속도가 빠르냐면 매번 1바이트씩 파일에 접근하면 속도가 느릴 수밖에 없다. 한번 갈 때 왕창 받아서 오는 것이다. 이 트럭을 버퍼라고 하고, 트럭을 가득 채워서 이동하는 것을 버퍼링이라 한다.

### 파일에 기본 자료형 데이터를 저장하고 싶은데, 버퍼링 기능도 추가하고 싶을 때!!
아까 파일에 기본 자료형 데이터를 저장할 때는 DataInputStream을 기본 스트림에 연결해 사용했다. 여기에 버퍼링 스트림을 연결하려면 순서가 어떻게 될까?
- 프로그램 - DataOutputStream -> BufferedOutputStream -> FileOutputStream

```java
public class BufferedDataOutputStream {
    public static void main(String[] args) {
        bufferedOutput();
        bufferedInput();
    }

    private static void bufferedOutput() {
        try(DataOutputStream out
                    = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream("data.md")))){
            out.writeInt(123);
            out.writeDouble(123.123);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedInput() {
        try (DataInputStream in =
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("data.md")))) {
            System.out.println(in.readInt());
            System.out.println(in.readDouble());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 문자 스트림의 이해와 활용
입출력 과정에서 '데이터의 변화 없이'바이트 단위로 데이터를 입력 및 출력하는 것이 입출력의 기본이다. 그러나 문자를 입출력할 때에는 약간의 데이터 수정이 필요하다. 자바에서는 이를 위해서 문자 스트림을 제공한다. 그런데 왜 문자를 처리할 때 따로 문자 스트림을 만들었을까?<br>
이는 문자가 각 운영체제에서 저장되는 방식이 다르기 때문이다. 문자는 기본적으로 유니코드 형식으로 저장된다. 자바에서 작성한 문자를 출력해 메모장에 옮기려면 각 운영체제에 맞는 유니코드로 변경해서 보내야 한다. 하지만 이건 너무 번거로운 일이다. 그래서 자바가 대신 운영 체제에 맞게 변환해주는 것이다.