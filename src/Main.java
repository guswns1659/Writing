import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1000);
        stack.push(100);
        int sum = stack.stream().mapToInt(s -> s).sum();
        System.out.println(sum);
    }
}
