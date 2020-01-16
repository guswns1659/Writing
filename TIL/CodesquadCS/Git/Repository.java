package CodesquadCS.Git;

import java.util.List;

public class Repository {
    private String path;
    private String name;
    private List<String> files;

    public Repository(String name) {
        this.path = name + "/";
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
