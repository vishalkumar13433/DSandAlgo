package src.atlassian.filesytem;

import src.atlassian.filesytem.system.File;
import src.atlassian.filesytem.system.FileSystem;

public class Driver {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addFile(new File("file1.txt", 100), null);
        fileSystem.addFile(new File("file2.txt", 200), "collection1");
        fileSystem.addFile(new File("file3.txt", 200), "collection1");
        fileSystem.addFile(new File("file7.txt", 200), "collection1");
        fileSystem.addFile(new File("file4.txt", 300), "collection2");
        fileSystem.addFile(new File("file4.txt", 800), "collection3");
        fileSystem.addFile(new File("file5.txt", 300), "collection3");
        fileSystem.addFile(new File("file1.txt", 10), null);


        System.out.println(fileSystem.getTotalSize());
        System.out.println(fileSystem.topCollectionsBySize(2));
    }
}
