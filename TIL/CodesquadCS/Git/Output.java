package CodesquadCS.Git;

public class Output {

    public void initPrint(String repositoryName) {
        System.out.printf("Create %s repository", repositoryName);
    }

    public void statusPrint(Local local) {
        System.out.println(local.getCurrentRepository());
    }

}
