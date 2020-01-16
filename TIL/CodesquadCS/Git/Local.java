package CodesquadCS.Git;

import java.util.ArrayList;

public class Local {
    private ArrayList<Repository> repositories;
    private String currentRepository;

    public Local() {
        this.currentRepository = "";
        repositories = new ArrayList<>();
    }

    public ArrayList<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(ArrayList<Repository> repositories) {
        this.repositories = repositories;
    }

    public String getCurrentRepository() {
        return currentRepository;
    }

    public void setCurrentRepository(String currentRepository) {
        this.currentRepository = currentRepository;
    }
}
