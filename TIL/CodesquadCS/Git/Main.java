package CodesquadCS.Git;

/*
0. prompt Class를 생성할 때 Local class를 생성한다.
1. Prompt class가 명령을 입력 받으면 명령어를 process 클래스에 process를 요청한다. EX) init hello
2. Git class에서 명령어를 parsing 한 뒤 명령어에 맞게 process를 한다.
    1) init hello-> Repository class를 만들고 생성자로 path와 name을 지정한다. 그 뒤 Local에 생성된 repository를 추가한다.
    2) status hello-> local class에서 hello 저장소의 path를 가져온다.
        만약, 없다면 local의 repositoies의 모든 저장소 목록을 추가한다.
    3) checkout hello -> local의 currentRepository를 hello로 바꾼다
*/


public class Main {
    public static void main(String[] args) {
        Local local = new Local();
        while (true) {
            Prompt prompt = new Prompt(local);
            String command = prompt.input();
            Git git = new Git(local);
            git.process(command);
        }
    }
}
