package CodesquadCS.Git;

import java.util.Scanner;

public class Prompt {
    Local local;
    public Prompt(Local local) {
        this.local = local;
        System.out.println(local.getCurrentRepository());
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s > ", local.getCurrentRepository());
        return scanner.nextLine();
    }
}
