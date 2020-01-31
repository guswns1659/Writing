## 목차
- I/O Stream
- 문자 스트림

## 핵심
- **Stream이란 데이터의 이동 통로이다**

## Stream이란?
스트림을 데이터의 이동 통로이다. close()를 하는 이유는 스트림에 할당된 자원을 반환하는 용도이다. 그리고 입력이나 출력이 끝났는 그 통로를 그대로 둘 필요가 없다.
기본적인 데이터의 입출력 단위는 바이트이고, 바이트 단위로 데이터를 입력 및 출력하는 스트림을 가리켜 '바이트 스트림'이라 한다. 왜 바이트일까? 생각해보면 컴퓨터의 모든 프로그램은 0과1로 이루어진 이진수이다. 그렇기 때문에 아무리 한글로 써있다고 해도 0과1로 바뀐다. 그래서 데이터의 기본 입출력 단위가 숫자인 바이트이다.

## Stream과 I.O Stream의 차이는?
map, reduce를 제공하는 Stream은 배열, 컬렉션에 담긴 데이터를 가공할 때 사용한다. 하지만 I.O Stream은 데이터를 입력받고 출력할 때 사용한다. 자바는 입출력 대상에 상관없이 동일한 방법으로 입출력을 진행할 수 있도록 I/O모델을 정의했다. 정확히 표현하자면 입출력 대상에 따른 입출력을 돕는 인스턴스는 다르지만 이들의 메서드는 똑같다. ex) read, write ...


## try-with-resources문
보다 안정적인 close 메서드의 호출이 보장된다.

```java
public class Write7ToFile3 {
    public static void main(String[] args) {
        output();
        input();
    }

    private static void output() {
        try(OutputStream out = new FileOutputStream("data.dat")) {
            out.write(7);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void input() {
        try (InputStream in = new FileInputStream("data.dat")){
            int dat = in.read();
            System.out.println(dat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


## FileInputStream, FileOutputStream의 read()와 write()
- read()는 파일로부터 읽어 들인 1바이트 유효한 데이터에 3바이트의 0을 채워서 4바이트 int형 데이터로 반환한다. 반면 스트림의 끝에 도달해서 더 이상 읽어 들일 데이터가 없는 경우 -1을 반환한다.
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

```java
public class SimpleWriter {
    public static void main(String[] args) {
        simpleWriter();
        simpleReader();
    }

    private static void simpleReader() {
        try(Reader in = new FileReader("data.md")) {
            System.out.println(in.read());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleWriter() {
        try(Writer out = new FileWriter("data.md")) {
            out.write("abc");
            out.write("def");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### FileReader & FileWriter
문자 스트림의 가장 부모 클래스는 Reader, Writer이다. 직관적으로 잘 지었다. 이를 기본으로 각 객체의 역할에 따라 부모 클래스를 상속한다. 구현은 객체에게 자율로 맡겨진다. 이게 객체지향 프로그래밍의 핵심이다.

```java
public class TextReader {
    public static void main(String[] args) {
        textReader();
    }

    private static void textReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("읽을 파일 : ");
        String source = scanner.nextLine();

        try (BufferedReader in =
                     new BufferedReader(new FileReader(source))) {
            String ch;
            while (true) {
                ch = in.readLine();
                if (ch == null) {
                    break;
                }
                System.out.println(ch);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### BufferedReader & BufferedWriter
input & output 스트림에도 BufferedInputStream & BufferedOutputStream 있는 것처럼 문자 스트림에도 BufferedReader & BufferedWriter가 존재한다. 한번에 훨씬 많은 양을 읽고 쓸 수 있다.

```java
public class StringWriter {
    public static void main(String[] args) {
        stringWriter();
        stringReader();
    }
    
    private static void stringWriter() {
        String string1 = "공부에 있어서 돈이 꼭 필요한 것은 아니다.";
        String string2 = "Life is long if you know how to use it.";

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("data.md"))){
            br.write(string1, 0, string1.length());
            br.newLine();
            br.write(string2, 0, string1.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        private static void stringReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("읽을 파일 : ");
        String source = scanner.nextLine();

        try (BufferedReader br =
                new BufferedReader(new FileReader(source))) {
            String line;
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
```

## IO 스트림 기반의 인스턴스 저장
IO 스트림을 이용하면 객체의 인스턴스도 저장할 수 있다. 이렇게 객체를 저장하는 것을 객체 직렬화(Object Serialization)이라고 한다. 반대로 꺼내는 것을 역 객체 직렬화라고 한다. 이 과정은 ObjectInputStream & ObjectOutputStream을 통해 이루어진다. 이 둘은 필터 스트림으로 기본 스트림에 연결해서 사용한다. <br>
입출력의 대상이 되는 인스턴스의 클래스는 java.io.Serializable을 구현해야 한다. 따로 오버라이딩할 메서드는 없다.

```java
public class ObjectOutput {
    public static void main(String[] args) {
        objectOutput();
        objectInput();
    }

    private static void objectOutput() {
        SBox sBox1 = new SBox("Robot");
        SBox sBox2 = new SBox("Strawberry");

        try (ObjectOutputStream oo =
                new ObjectOutputStream(
                        new FileOutputStream("object.bin"))) {
            oo.writeObject(sBox1);
            oo.writeObject(sBox2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void objectInput() {
        try (ObjectInputStream oi =
                new ObjectInputStream(new FileInputStream("object.bin"))) {

            SBox sBox1 = (SBox) oi.readObject();
            System.out.println(sBox1.getS());
            SBox sBox2 = (SBox) oi.readObject();
            System.out.println(sBox2.getS());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

```