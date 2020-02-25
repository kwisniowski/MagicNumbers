import java.io.File;

public class FileDifferentiator {

    public String getFileEtrension(File file) {
        int dotIndex = file.getName().lastIndexOf(".");
        return file.getName().substring(dotIndex+1,dotIndex+4);
    }
}
