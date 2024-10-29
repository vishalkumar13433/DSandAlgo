package src.atlassian.filesytem.system;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    public String name;
    public List<File> files;
    public int size;

    public Collection(String name) {
        this.name = name;
        files = new ArrayList<>();
        size = 0;
    }

    public void addFile(File file) {
        this.files.add(file);
        this.size += file.size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
