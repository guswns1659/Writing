package CodesquadCS.Git;

public class Init {
    public Init(Local local, String repositoryName) {
        Repository repository = new Repository(repositoryName);
        local.getRepositories().add(repository);
        local.setCurrentRepository(repository.getName());
    }
}
