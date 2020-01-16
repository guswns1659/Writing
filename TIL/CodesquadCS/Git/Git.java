package CodesquadCS.Git;

public class Git {
    Local local;
    public Git(Local local) {
        this.local = local;
    }

    public void process(String inputCommand) {
        Output output = new Output();
        String[] parsedCommand = CommandParser(inputCommand);
        String command = parsedCommand[0];
        switch (command) {
            case "init":
                String repositoryName = parsedCommand[1];
                Init init = new Init(local, repositoryName);
                output.initPrint(repositoryName);
                break;
            case "status":
                output.statusPrint(local);
        }
    }


    private String[] CommandParser(String command) {
        return command.split(" ");
    }

}
