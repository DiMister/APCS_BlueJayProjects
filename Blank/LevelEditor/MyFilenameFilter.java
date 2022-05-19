package LevelEditor;
// Java Program to Search for a File in a Directory
import java.io.*;

// MyFilenameFilter class implements FilenameFilter
// interface
class MyFilenameFilter implements FilenameFilter {

    String initials;

    // constructor to initialize object
    public MyFilenameFilter(String initials)
    {
        this.initials = initials;
    }

    // overriding the accept method of FilenameFilter
    // interface
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
}

