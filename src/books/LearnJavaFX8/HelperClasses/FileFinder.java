package books.LearnJavaFX8.HelperClasses;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileFinder extends SimpleFileVisitor<Path> {

    private PathMatcher matcher;
    private ArrayList<Path> foundPaths = new ArrayList<>();

    public FileFinder(String filePattern) {
        this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + filePattern);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path fileName = file.getFileName();
        System.out.println("Examining: " + fileName);

        if (this.matcher.matches(fileName)) {
            this.foundPaths.add(file);
        }
        return FileVisitResult.CONTINUE;        // keep on moving in the directory tree
    }

    public ArrayList<Path> getFoundPaths() {
        return this.foundPaths;
    }
}
